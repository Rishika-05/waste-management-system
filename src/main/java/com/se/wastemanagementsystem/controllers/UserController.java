package com.se.wastemanagementsystem.controllers;

import com.se.wastemanagementsystem.service.UserService;
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

    private UserService userService;
    @PutMapping("/register")
    public ResponseEntity<CoreResponse<Object>> register(@RequestBody Map<String, String> req){
        return CoreResponse.buildSuccessResponseWithData(userService.register(req));
    }

    @PutMapping("/login")
    public ResponseEntity<CoreResponse<Object>> login(@RequestBody Map<String, String> req){
        return CoreResponse.buildSuccessResponseWithData(userService.login(req));
    }

    @GetMapping("/details")
    public ResponseEntity<CoreResponse<Object>> getDetails(@RequestHeader("Authorization") Integer id){
        return CoreResponse.buildSuccessResponseWithData(userService.getDetails(id));
    }
}
