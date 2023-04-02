package com.se.wastemanagementsystem.controllers;

import com.se.wastemanagementsystem.service.WasteGenerator;
import com.se.wastemanagementsystem.utils.CoreResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/wg")
public class WgController {
    private final WasteGenerator wasteGenerator;
    @PutMapping("/update-waste")
    public ResponseEntity<CoreResponse<Object>> generateWaste(@RequestHeader("Authorization") Integer id, @RequestBody Map<String, String> req){
        return CoreResponse.buildSuccessResponseWithData(wasteGenerator.generateWaste(id, req));
    }
    @PutMapping("/req-collection")
    public ResponseEntity<CoreResponse<Object>> requestCollection(@RequestHeader("Authorization") Integer id, @RequestBody Map<String, Object> req){
        return CoreResponse.buildSuccessResponseWithData(wasteGenerator.requestCollection(id, req));
    }
}
