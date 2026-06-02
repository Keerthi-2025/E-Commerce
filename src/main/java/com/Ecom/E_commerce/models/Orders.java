package com.Ecom.E_commerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "orders")   // changed
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

    @Id
    private String order_id;

    @Column
    private String total_amt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItems> orderItemsList;
}