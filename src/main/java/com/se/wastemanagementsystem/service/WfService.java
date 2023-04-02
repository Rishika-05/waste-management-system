package com.se.wastemanagementsystem.service;

import java.util.Map;

public interface WfService {
    Map<String, Object> updateAQ(Integer id, Map<String, String> req);

    Map<String, Object> updateWasteInfo(Integer id, Map<String, Object> req);

}
