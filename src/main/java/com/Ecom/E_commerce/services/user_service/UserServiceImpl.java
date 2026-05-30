package com.Ecom.E_commerce.services.user_service;

import com.Ecom.E_commerce.models.User;
import com.Ecom.E_commerce.repositories.UserRepository;
import org.springframework.security.config.core.userdetails.UserDetailsMapFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public String createUser(String userId, String userName, String password, String email) {

        return "";
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User getUserId(String userId) {
        return null;
    }
}


