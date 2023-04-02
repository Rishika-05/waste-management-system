package com.se.wastemanagementsystem.service;

import java.util.Map;

public interface User {
    Map<String, Integer> register(Map<String, String> req);
    Map<String, Integer> login(Map<String, String> req);
    Map<String, Object> getDetails(Integer id);
    Map<String, Object> updateDetails(Integer id, Map<String, String> req);

    Map<String, Object> getWasteInfo(Integer id);
}
