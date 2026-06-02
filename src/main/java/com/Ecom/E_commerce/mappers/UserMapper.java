package com.Ecom.E_commerce.mappers;

import com.Ecom.E_commerce.models.User;
import org.springframework.stereotype.Component;


@Component

public class UserMapper {
    public User touser(String userId, String userName, String password, String email){
        return  User.builder()
                .userId(userId)
                .userName(userName)
                .password(password)
                .email(email)
        .build();
    }
}
