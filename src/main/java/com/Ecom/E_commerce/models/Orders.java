package com.Ecom.E_commerce.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "Order")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Orders {

    @Id
    private String order_id;

    @Column
    private String total_amt;


    @ManyToMany
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItems> orderItemsList;

}
