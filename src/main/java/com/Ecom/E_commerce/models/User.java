package com.Ecom.E_commerce.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToOne(mappedBy = "user")
    @JsonBackReference("user-cart")
    private Cart cart;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Orders> order;

}
