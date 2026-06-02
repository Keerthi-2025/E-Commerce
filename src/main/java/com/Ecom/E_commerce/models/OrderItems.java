package com.Ecom.E_commerce.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "order_items")   // recommended naming
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItems {

    @Id
    private Integer orderItms_id;

    @Column
    private String or_qty;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}