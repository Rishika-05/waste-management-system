package com.se.wastemanagementsystem.service.impl;

import com.se.wastemanagementsystem.service.WfacilityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FacilityServiceImpl implements WfacilityService {
    @Override
    public void processWaste() {
        System.out.println("Waste is being Processes");
    }

    @Override
    public void disposeWaste() {
        System.out.println("Remaining waste is disposed");
    }
}
