package com.se.wastemanagementsystem.service;

import java.util.Map;

public interface GoService {
    Map<String, Object> monitorAQ(Integer id, Map<String, String> req);

}
