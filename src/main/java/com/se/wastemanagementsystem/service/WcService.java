package com.se.wastemanagementsystem.service;

import java.util.Map;

public interface WcService {
    Map<String, Object> collectWaste(Integer id, Map<String, Object> req);

    Map<String, Object> transportWaste(Integer id, Map<String, Object> req);

}
