package com.se.wastemanagementsystem.controllers;

import com.se.wastemanagementsystem.service.WfService;
import com.se.wastemanagementsystem.utils.CoreResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/wf")
public class WfController {
    private final WfService wfService;

    @PutMapping("/update-aq")
    public ResponseEntity<CoreResponse<Object>> updateAq(@RequestHeader("Authorization") Integer id, @RequestBody Map<String, String> req){
        return CoreResponse.buildSuccessResponseWithData(wfService.updateAQ(id, req));
    }

    @PutMapping("/update-waste")
    public ResponseEntity<CoreResponse<Object>> updateWasteInfo(@RequestHeader("Authorization") Integer id, @RequestBody Map<String, Object> req){
        return CoreResponse.buildSuccessResponseWithData(wfService.updateWasteInfo(id, req));
    }

}
