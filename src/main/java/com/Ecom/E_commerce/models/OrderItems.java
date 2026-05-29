package com.Ecom.E_commerce.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "OrderItems")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderItems {

    @Id
    private String orderItms_id;

    @Column
    private  String or_qty;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private  Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
