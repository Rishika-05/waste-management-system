package com.se.wastemanagementsystem.service;

import java.util.Map;

public interface WgService {
    Map<String, Object> generateWaste(Integer id, Map<String, String> req);

    Map<String, Object> requestCollection(Integer id, Map<String, Object> req);

}
