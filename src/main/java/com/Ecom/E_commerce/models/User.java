package com.Ecom.E_commerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

    @Id
    private  String  userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private  String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private  String role;


}
