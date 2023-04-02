package com.se.wastemanagementsystem.service.impl;

import com.se.wastemanagementsystem.entity.WasteEntity;
import com.se.wastemanagementsystem.entity.WasteGeneratorEntity;
import com.se.wastemanagementsystem.repository.WasteGeneratorRepo;
import com.se.wastemanagementsystem.repository.WasteRepo;
import com.se.wastemanagementsystem.service.WasteGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class WasteGeneratorImpl implements WasteGenerator {
    private final WasteGeneratorRepo wasteGeneratorRepo;
    private final WasteRepo wasteRepo;
    @Override
    public Map<String, Object> generateWaste(Integer id, Map<String, String> req) {
        WasteGeneratorEntity wg = wasteGeneratorRepo.findByUserId(id);
        WasteEntity w = new WasteEntity();
        w.setAmountInGms(Double.parseDouble(req.get("amount")));
        w.setType(req.get("type"));
        w.setGeneratedAt(LocalDateTime.now());
        w.setWgId(id);
        w.setTransported(false);
        w.setProcessed(false);
        w.setCollectionRequested(false);
        wasteRepo.save(w);
        return null;
    }

    @Override
    public Map<String, Object> requestCollection(Integer id, Map<String, Object> req) {
        List<Integer> wasteIds = (List<Integer>) req.get("ids");
        List<WasteEntity> we = wasteRepo.findAllByIdIn(wasteIds);
        for(WasteEntity w: we) {
            w.setCollectionRequested(true);
        }
        wasteRepo.saveAll(we);
        return null;
    }

}
