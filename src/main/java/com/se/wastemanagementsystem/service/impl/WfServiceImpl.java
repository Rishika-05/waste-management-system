package com.se.wastemanagementsystem.service.impl;

import com.se.wastemanagementsystem.entity.AirQualityEntity;
import com.se.wastemanagementsystem.entity.WasteEntity;
import com.se.wastemanagementsystem.entity.WasteFacilitatorEntity;
import com.se.wastemanagementsystem.repository.AirQualityRepo;
import com.se.wastemanagementsystem.repository.WasteFacilitatorRepo;
import com.se.wastemanagementsystem.repository.WasteRepo;
import com.se.wastemanagementsystem.service.WfService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class WfServiceImpl implements WfService {

    private final AirQualityRepo airQualityRepo;
    private final WasteRepo wasteRepo;
    private final WasteFacilitatorRepo wasteFacilitatorRepo;

    @Override
    public Map<String, Object> updateAQ(Integer id, Map<String, String> req) {
        AirQualityEntity aq = new AirQualityEntity();
        aq.setIndex(Float.valueOf(req.get("aq")));
        aq.setFkFacilityId(Integer.valueOf(req.get("facilityId")));
        LocalDate date = LocalDate.parse(req.get("datetime"));
         aq.setRecordedAt(date);
        airQualityRepo.save(aq);
        return null;
    }

    @Override
    public Map<String, Object> updateWasteInfo(Integer id, Map<String, Object> req) {
        List<Integer> wasteIds = (List<Integer>) req.get("ids");
        List<WasteEntity> we = wasteRepo.findAllByIdIn(wasteIds);
        WasteFacilitatorEntity wf = wasteFacilitatorRepo.findByUserId(id);
        for(WasteEntity w: we) {
            w.setProcessedAt(LocalDateTime.now());
            w.setWfId(wf.getFkFacilityId());
            w.setProcessed(true);
        }
        wasteRepo.saveAll(we);
        return null;
    }


}
