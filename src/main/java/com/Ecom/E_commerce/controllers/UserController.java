package com.Ecom.E_commerce.controllers;


import com.Ecom.E_commerce.Dto.Request.CreateUserDto;
import com.Ecom.E_commerce.models.User;
import com.Ecom.E_commerce.services.user_service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/User")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/v1/createuser")
    public ResponseEntity<String> createUser(@RequestBody CreateUserDto data){
        String message = userService.createUser(data.userId(), data.userName(), data.password(), data.email());
        return ResponseEntity.status(201).body(message);
    }

    @GetMapping("/v1/getAllUsers")
    ResponseEntity<List<User>> getAllUsers(){
        return  ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @GetMapping("/v1/getUserId")
    ResponseEntity<User>getUserId(@RequestParam("userId") String userId){
        return ResponseEntity.status(200).body(userService.getUserId(userId));
    }
}
