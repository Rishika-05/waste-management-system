package com.se.wastemanagementsystem.controllers;

import com.se.wastemanagementsystem.service.User;
import com.se.wastemanagementsystem.utils.CoreResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

    private User user;
    @PutMapping("/register")
    public ResponseEntity<CoreResponse<Object>> register(@RequestBody Map<String, String> req){
        return CoreResponse.buildSuccessResponseWithData(user.register(req));
    }

    @PutMapping("/login")
    public ResponseEntity<CoreResponse<Object>> login(@RequestBody Map<String, String> req){
        return CoreResponse.buildSuccessResponseWithData(user.login(req));
    }

    @GetMapping("/details")
    public ResponseEntity<CoreResponse<Object>> getDetails(@RequestHeader("Authorization") Integer id){
        return CoreResponse.buildSuccessResponseWithData(user.getDetails(id));
    }

    @PutMapping("/profile")
    public ResponseEntity<CoreResponse<Object>> updateDetails(@RequestBody Map<String, String> req, @RequestHeader("Authorization") Integer id){
        return CoreResponse.buildSuccessResponseWithData(user.updateDetails(id, req));
    }

    @GetMapping("/waste")
    public ResponseEntity<CoreResponse<Object>> getWasteInfo(@RequestHeader("Authorization") Integer id){
        return CoreResponse.buildSuccessResponseWithData(user.getWasteInfo(id));
    }
}
