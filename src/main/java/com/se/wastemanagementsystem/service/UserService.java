package com.se.wastemanagementsystem.service;

import java.util.Map;

public interface UserService {
    Map<String, Integer> register(Map<String, String> req);
    Map<String, Integer> login(Map<String, String> req);
    Map<String, Object> getDetails(Integer id);
}
