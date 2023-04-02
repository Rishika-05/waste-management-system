package com.se.wastemanagementsystem.service.impl;

import com.se.wastemanagementsystem.entity.WasteFacilityEntity;
import com.se.wastemanagementsystem.repository.WasteFaciltyRepo;
import com.se.wastemanagementsystem.service.Admin;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class AdminImpl implements Admin {

    private final WasteFaciltyRepo wasteFaciltyRepo;
    @Override
    public Map<String, Object> getFacilities() {
        List<Map<String, Object>> data = new ArrayList<>();
        List<WasteFacilityEntity> wfs =  wasteFaciltyRepo.findAll();
        for(WasteFacilityEntity wf: wfs){
            data.add(Map.of("id", wf.getId(), "name", wf.getName()));
        }
        return Map.of("facilities", data);
    }

    @Override
    public void addFacility(Map<String, String> req) {
        WasteFacilityEntity wf = new WasteFacilityEntity();
        wf.setAddress(req.get("address"));
        wf.setCity(req.get("city"));
        wf.setState(req.get("state"));
        wf.setPincode(Integer.valueOf(req.get("pincode")));
        wf.setName(req.get("name"));
        wasteFaciltyRepo.save(wf);
    }

}
