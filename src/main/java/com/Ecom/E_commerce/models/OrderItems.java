package com.Ecom.E_commerce.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItems {

    @Id
    private Integer orderItms_Id;

    @Column
    private Integer ord_qty;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}