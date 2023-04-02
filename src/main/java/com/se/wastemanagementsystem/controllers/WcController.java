package com.se.wastemanagementsystem.controllers;

import com.se.wastemanagementsystem.service.WasteCollector;
import com.se.wastemanagementsystem.utils.CoreResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/wc")
public class WcController {
    private final WasteCollector wasteCollector;
    @PutMapping("/update-waste")
    public ResponseEntity<CoreResponse<Object>> collectWaste(@RequestHeader("Authorization") Integer id, @RequestBody Map<String, Object> req){
        return CoreResponse.buildSuccessResponseWithData(wasteCollector.collectWaste(id, req));
    }

    @PutMapping("/update-waste-2")
    public ResponseEntity<CoreResponse<Object>> transportWaste(@RequestHeader("Authorization") Integer id, @RequestBody Map<String, Object> req){
        return CoreResponse.buildSuccessResponseWithData(wasteCollector.transportWaste(id, req));
    }
}
