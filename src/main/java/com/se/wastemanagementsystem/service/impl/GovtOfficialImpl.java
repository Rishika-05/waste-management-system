package com.se.wastemanagementsystem.service.impl;

import com.se.wastemanagementsystem.entity.AirQualityEntity;
import com.se.wastemanagementsystem.entity.WasteFacilityEntity;
import com.se.wastemanagementsystem.repository.AirQualityRepo;
import com.se.wastemanagementsystem.repository.WasteFaciltyRepo;
import com.se.wastemanagementsystem.service.GovtOfficial;
import com.se.wastemanagementsystem.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class GovtOfficialImpl implements GovtOfficial {
    private final AirQualityRepo airQualityRepo;
    private final WasteFaciltyRepo wasteFaciltyRepo;

    @Override
    public Map<String, Object> monitorAQ(Integer id, Map<String, String> req) {
        LocalDate date = LocalDate.now().minusDays(1);
        if(req.get("date") != "")
            date = LocalDate.parse(req.get("date"));
        List<AirQualityEntity> aqs = airQualityRepo.findAllByRecordedAtAfter(date);
        List<Map<String, Object>> aqis = new ArrayList<>();
        for(AirQualityEntity aq: aqs){
            WasteFacilityEntity wf = wasteFaciltyRepo.findById(aq.getFkFacilityId()).get();
            Map<String, Object> data = new HashMap<>();
            data.put("recordDate", Utils.getFormattedDate(aq.getRecordedAt()));
            data.put("aq", aq.getIndex());
            data.put("facilityId", aq.getFkFacilityId());
            data.put("name", wf.getName());
            data.put("city", wf.getCity());
            data.put("state", wf.getState());
            data.put("pincode", wf.getPincode());
            data.put("address", wf.getAddress());
            aqis.add(data);
        }
        return Map.of("aqis", aqis);
    }

}
