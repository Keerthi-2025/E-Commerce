package com.Ecom.E_commerce.services.user_service;


import com.Ecom.E_commerce.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    String createUser(String userId, String userName, String password, String email);

    List<User> getAllUsers();

    User getUserId(String userId);
}
