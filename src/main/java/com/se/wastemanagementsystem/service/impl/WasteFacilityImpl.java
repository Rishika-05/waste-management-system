package com.se.wastemanagementsystem.service.impl;

import com.se.wastemanagementsystem.service.WasteFacility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WasteFacilityImpl implements WasteFacility {
    @Override
    public void processWaste() {
        System.out.println("Waste is being Processes");
    }

    @Override
    public void disposeWaste() {
        System.out.println("Remaining waste is disposed");
    }
}
