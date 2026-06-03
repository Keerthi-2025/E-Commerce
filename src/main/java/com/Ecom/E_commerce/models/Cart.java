package com.Ecom.E_commerce.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "Cart")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Cart {

    @Id
    private  Integer cart_id;

  @OneToOne
  @JoinColumn(name = "user_id")
  @JsonManagedReference("user-cart")
  private  User user;

  @OneToMany(mappedBy = "cart")
  @JsonManagedReference
  private List <CartItems> cartItems;
}
