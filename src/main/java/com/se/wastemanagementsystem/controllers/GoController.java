package com.se.wastemanagementsystem.controllers;

import com.se.wastemanagementsystem.service.GovtOfficial;
import com.se.wastemanagementsystem.utils.CoreResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/go")
public class GoController {
    private final GovtOfficial govtOfficial;
    @PutMapping("/aq")
    public ResponseEntity<CoreResponse<Object>> monitorAQ(@RequestHeader("Authorization") Integer id, @RequestBody Map<String, String> req){
        return CoreResponse.buildSuccessResponseWithData(govtOfficial.monitorAQ(id, req));
    }

}
