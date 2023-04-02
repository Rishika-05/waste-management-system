package com.se.wastemanagementsystem.service.impl;

import com.se.wastemanagementsystem.entity.WasteCollectorEntity;
import com.se.wastemanagementsystem.entity.WasteEntity;
import com.se.wastemanagementsystem.repository.WasteCollectorRepo;
import com.se.wastemanagementsystem.repository.WasteRepo;
import com.se.wastemanagementsystem.service.WcService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class WcServiceImpl implements WcService {

    private final WasteRepo wasteRepo;
    private final WasteCollectorRepo wasteCollectorRepo;

    @Override
    public Map<String, Object> collectWaste(Integer id, Map<String, Object> req) {
        List<Integer> wasteIds = (List<Integer>) req.get("ids");
        List<WasteEntity> we = wasteRepo.findAllByIdIn(wasteIds);
        for(WasteEntity w: we) {
            w.setCollectedAt(LocalDateTime.now());
            w.setWcId(id);
            w.setTransported(true);
        }
        wasteRepo.saveAll(we);
        return null;
    }

    @Override
    public Map<String, Object> transportWaste(Integer id, Map<String, Object> req) {
        List<Integer> wasteIds = (List<Integer>) req.get("ids");
        List<WasteEntity> we = wasteRepo.findAllByIdIn(wasteIds);
        for(WasteEntity w: we) {
            w.setTransported(true);
        }
        wasteRepo.saveAll(we);
        return null;
    }

}
