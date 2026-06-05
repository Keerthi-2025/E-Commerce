package com.Ecom.E_commerce.services.user_service;


import com.Ecom.E_commerce.Dto.Response.LoginResponse;
import com.Ecom.E_commerce.models.User;


import java.util.List;


public interface UserService {

    LoginResponse loginUser(String email, String password);

    String createUser(String userId, String userName, String password, String email);

    List<User> getAllUsers();

    User getUserId(String userId);
}
