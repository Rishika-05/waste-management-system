package com.se.wastemanagementsystem.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.wastemanagementsystem.entity.*;
import com.se.wastemanagementsystem.enums.ResponseCodes;
import com.se.wastemanagementsystem.enums.Roles;
import com.se.wastemanagementsystem.exception.SwmsException;
import com.se.wastemanagementsystem.repository.*;
import com.se.wastemanagementsystem.service.UserService;
import com.se.wastemanagementsystem.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final WasteGeneratorRepo wasteGeneratorRepo;
    private final WasteCollectorRepo wasteCollectorRepo;
    private final WasteFacilitatorRepo wasteFacilitatorRepo;
    private final GovtOfficialRepo govtOfficialRepo;

    private final ObjectMapper oMapper = new ObjectMapper();

    @Override
    public Map<String, Integer> register(Map<String, String> req){
        UserEntity user = new UserEntity();
        UserEntity userDb = userRepository.findByPhoneNo(req.get("phoneNo"));
        if(Objects.nonNull(userDb)){
            throw new SwmsException(ResponseCodes.BAD_REQUEST, "Phone no. is already registered");
        }
        user.setPhoneNo(req.get("phoneNo"));
        user.setName(req.get("name"));
        user.setPassword(Utils.encrypt256(req.get("password")));
        user.setRole(Roles.valueOf(req.get("role")));
        user = userRepository.save(user);
        return Map.of("id", user.getId());
    }
    @Override
    public Map<String, Integer> login(Map<String, String> req){
        UserEntity user = userRepository.findByPhoneNo(req.get("phoneNo"));
        if(Objects.isNull(user)){
            throw new SwmsException(ResponseCodes.BAD_REQUEST, "Phone no. not registered");
        }
        if(!Utils.encrypt256(req.get("password")).equals(user.getPassword())){
            throw new SwmsException(ResponseCodes.VALIDATION_ERROR, "Invalid Credentials");
        }
        return Map.of("id", user.getId());
    }

    public  Map<String, Object> getProfile(UserEntity user){
        Map<String, Object> data = new HashMap<>();
        if(user.getRole().equals(Roles.WG)){
            WasteGeneratorEntity wg = wasteGeneratorRepo.findByUserId(user.getId());
            if(Objects.nonNull(wg)){
                data.put("address", wg.getAddress());
                data.put("city", wg.getCity());
                data.put("state", wg.getState());
                data.put("pincode", wg.getPincode());
            }
        }else if (user.getRole().equals(Roles.WC)){
            WasteCollectorEntity wc = wasteCollectorRepo.findByUserId(user.getId());
            if(Objects.nonNull(wc)){
                data.put("pincode", wc.getPincode());
                data.put("vehicle_no", wc.getVehicleNo());
            }
        }else if(user.getRole().equals(Roles.WF)){
            WasteFacilitatorEntity wf = wasteFacilitatorRepo.findByUserId(user.getId());
            if(Objects.nonNull(wf)){
                data.put("joining_date", wf.getDate());
                data.put("facility", wf.getFkFacilityId());
            }
        } else if (user.getRole().equals(Roles.GO)) {
            GovtOfficialEntity go = govtOfficialRepo.findByUserId(user.getId());
            if(Objects.nonNull(go)){
                data.put("department", go.getDepartment());
                data.put("pincode_csv", go.getPincodeCsv());
            }
        }
        return data;
    }

    @Override
    public Map<String, Object> getDetails(Integer id){
        UserEntity user = userRepository.findById(id).get();
        Map<String, Object> data = new HashMap<>();
        data.put("phoneNo", user.getPhoneNo());
        data.put("name", user.getName());
        data.put("role", user.getRole());
        data.put("profile", getProfile(user));
        return data;
    }
}
