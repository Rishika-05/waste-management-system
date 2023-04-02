package com.se.wastemanagementsystem.controllers;

import com.se.wastemanagementsystem.service.Admin;
import com.se.wastemanagementsystem.utils.CoreResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {
    private final Admin admin;
    @GetMapping("/facilities")
    public ResponseEntity<CoreResponse<Object>> updateDetails(){
        return CoreResponse.buildSuccessResponseWithData(admin.getFacilities());
    }
    @PutMapping("/add-facility")
    public ResponseEntity<CoreResponse<Object>> addFacility(@RequestBody Map<String, String> req){
        admin.addFacility(req);
        return CoreResponse.buildSuccessResponse();
    }
}
