package com.Ecom.E_commerce.repositories;


import com.Ecom.E_commerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository  extends  JpaRepository<User, String>{


    User findByEmail(String email);
}
