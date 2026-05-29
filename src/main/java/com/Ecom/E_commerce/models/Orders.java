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

}
