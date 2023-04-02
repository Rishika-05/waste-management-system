package com.se.wastemanagementsystem.service;

import java.util.Map;

public interface Admin {
    Map<String, Object> getFacilities();

    void addFacility(Map<String, String> req);

}
