package com.Ecom.E_commerce.services.user_service;

import com.Ecom.E_commerce.Dto.Response.LoginResponse;
import com.Ecom.E_commerce.exceptions.ApiRequestException;
import com.Ecom.E_commerce.mappers.UserMapper;
import com.Ecom.E_commerce.models.User;

import com.Ecom.E_commerce.repositories.UserRepository;
import org.springframework.security.config.core.userdetails.UserDetailsMapFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository;
    private final UserMapper userMapper;
//    private  final UUIDUtil uuidUtil;

    public   UserServiceImpl(UserRepository userRepository, UserMapper userMapper){

        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public LoginResponse loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return new LoginResponse(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getRole(),
                "Login successful"
        );
    }

    @Override
    public String createUser(String userId, String userName, String password, String email) {
        User user = userMapper.touser(userId,userName,password,email);
        userRepository.save(user);
        return "User created";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserId(String userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ApiRequestException("User ID not found"));
    }
}


