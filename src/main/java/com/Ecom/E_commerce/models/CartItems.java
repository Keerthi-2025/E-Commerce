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
@Table(name = "CartItem")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CartItems {

    @Id
    private String cartItm_id;

    @Column(nullable = false)
    private  String qty;



}
