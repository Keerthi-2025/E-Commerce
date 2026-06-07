package com.Ecom.E_commerce.controllers;


import com.Ecom.E_commerce.Dto.Request.CreateUserDto;
import com.Ecom.E_commerce.Dto.Request.LoginDto;
import com.Ecom.E_commerce.Dto.Request.SignupDto;
import com.Ecom.E_commerce.Dto.Response.LoginResponse;
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

    @PostMapping("/v1/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginDto data){

        LoginResponse response = userService.loginUser(
                data.email(),
                data.password()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/v1/signup")
    public ResponseEntity<String> signup(@RequestBody SignupDto data){
        String message = userService.signupUser(data.userId(), data.userName(), data.email(), data.password());
        return ResponseEntity.status(201).body(message);
    }
}
