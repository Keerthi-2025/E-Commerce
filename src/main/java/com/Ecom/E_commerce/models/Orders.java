package com.Ecom.E_commerce.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

    @Id
    private Integer orderId;

    private String totalAmt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(mappedBy = "order")
//    private List<OrderItems> orderItems;
}