package com.Ecom.E_commerce.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Cart")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Cart {

    @Id
    private  String cart_id;

  @OneToOne
  @JoinColumn(name = "user_id")
  private  User user;
}
