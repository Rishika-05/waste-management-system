package com.se.wastemanagementsystem.service.impl;

import com.se.wastemanagementsystem.entity.*;
import com.se.wastemanagementsystem.enums.ResponseCodes;
import com.se.wastemanagementsystem.enums.Roles;
import com.se.wastemanagementsystem.exception.SwmsException;
import com.se.wastemanagementsystem.repository.*;
import com.se.wastemanagementsystem.service.User;
import com.se.wastemanagementsystem.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class UserImpl implements User {
    private final UserRepository userRepository;
    private final WasteGeneratorRepo wasteGeneratorRepo;
    private final WasteCollectorRepo wasteCollectorRepo;
    private final WasteFacilitatorRepo wasteFacilitatorRepo;
    private final GovtOfficialRepo govtOfficialRepo;
    private final WasteFaciltyRepo wasteFaciltyRepo;
    private final WasteRepo wasteRepo;

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
                data.put("joining_date", Utils.getFormattedDate(wf.getDate()));
                data.put("facility_id", wf.getFkFacilityId());
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
        data.put("roleLabel", user.getRole().getLabel());
        data.put("profile", getProfile(user));
        return data;
    }

    @Override
    public Map<String, Object> updateDetails(Integer id, Map<String, String> req){
        UserEntity user = userRepository.findById(id).get();
        if(user.getRole().equals(Roles.WG)){
            WasteGeneratorEntity wg = wasteGeneratorRepo.findByUserId(user.getId());
            if(Objects.isNull(wg)){
                wg = new WasteGeneratorEntity();
            }
            wg.setUserId(id);
            wg.setAddress(req.get("address"));
            wg.setCity(req.get("city"));
            wg.setState(req.get("state"));
            wg.setPincode(Integer.valueOf(req.get("pincode")));
            wasteGeneratorRepo.save(wg);
        }else if (user.getRole().equals(Roles.WC)){
            WasteCollectorEntity wc = wasteCollectorRepo.findByUserId(user.getId());
            if(Objects.isNull(wc)){
                wc = new WasteCollectorEntity();
            }
            wc.setUserId(id);
            wc.setPincode(Integer.valueOf(req.get("pincode")));
            wc.setVehicleNo(req.get("vehicleNo"));
            wasteCollectorRepo.save(wc);
        }else if(user.getRole().equals(Roles.WF)){
            WasteFacilitatorEntity wf = wasteFacilitatorRepo.findByUserId(user.getId());
            if(Objects.isNull(wf)){
                wf = new WasteFacilitatorEntity();
            }
            wf.setUserId(id);
            wf.setFkFacilityId(Integer.valueOf(req.get("facilityId")));
            wf.setDate(LocalDate.parse(req.get("joiningDate")));
            wasteFacilitatorRepo .save(wf);
        } else if (user.getRole().equals(Roles.GO)) {
            GovtOfficialEntity go = govtOfficialRepo.findByUserId(user.getId());
            if(Objects.isNull(go)){
                go = new GovtOfficialEntity();
            }
            go.setUserId(id);
            go.setDepartment(req.get("department"));
            go.setPincodeCsv(req.get("pincodeCsv"));
            govtOfficialRepo.save(go);
        }
        return getDetails(id);
    }

    @Override
    public Map<String, Object> getWasteInfo(Integer id) {
        LocalDateTime dt = LocalDateTime.now().minusDays(1);
        LocalDate date = LocalDate.now().minusDays(1);
//        if(Objects.nonNull(req.get("datetime")));
//            dt = LocalDateTime.parse(req.get("datetime"));
        UserEntity user = userRepository.findById(id).get();
        List<Map<String, Object>> wl = new ArrayList<>();
        List<WasteEntity> wastes = new ArrayList<>();
        if(user.getRole().equals(Roles.ADMIN) || user.getRole().equals(Roles.GO)) {
            wastes = wasteRepo.findAllByGeneratedAtAfter(dt);
        }else if(user.getRole().equals(Roles.WG)){
            wastes = wasteRepo.findAllByGeneratedAtAfterAndWgId(dt, id);
//            wastes = wasteRepo.findAllByWgId(id);
        }else if(user.getRole().equals(Roles.WC)){
            wastes = wasteRepo.findAllByGeneratedAtAfterAndCollectionRequestedTrue(dt);
        }else if (user.getRole().equals(Roles.WF)){
            wastes = wasteRepo.findAllByGeneratedAtAfterAndTransportedTrue(dt);
        }
//        ObjectMapper oMapper = new ObjectMapper();
        for (WasteEntity waste : wastes) {
            Map<String, Object> data  = new HashMap<>();
            WasteGeneratorEntity wg = wasteGeneratorRepo.findByUserId(waste.getWgId());
            data.put("id", waste.getId());
            data.put("type", waste.getType());
            data.put("amount", waste.getAmountInGms());
            data.put("generatedAt", Utils.getFormattedDatetime(waste.getGeneratedAt()));
            data.put("collectedAt", Utils.getFormattedDatetime(waste.getCollectedAt()));
            data.put("processedAt", Utils.getFormattedDatetime(waste.getProcessedAt()));
            data.put("collectionReq", waste.isCollectionRequested());
            data.put("transported", waste.isTransported());
            data.put("processed", waste.isProcessed());
            data.put("address", wg.getAddress());
            data.put("city", wg.getCity());
            data.put("state", wg.getState());
            data.put("pincode", wg.getPincode());
            wl.add(data);
        }
        return Map.of("wastes", wl);
    }
}
