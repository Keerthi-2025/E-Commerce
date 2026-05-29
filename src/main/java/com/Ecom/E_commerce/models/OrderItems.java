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
@Table(name = "OrderItems")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderItems {

    @Id
    private String orderItms_id;

    @Column
    private  String or_qty;

}
