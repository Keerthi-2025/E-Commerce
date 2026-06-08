package com.Ecom.E_commerce.controllers;


import com.Ecom.E_commerce.Dto.Request.CreateOrderItemsDto;
import com.Ecom.E_commerce.models.OrderItems;
import com.Ecom.E_commerce.services.orderitems_service.OrderItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/OrderItems")

public class OrderItemsController {

    public final OrderItemsService orderItemsService;

    public OrderItemsController(OrderItemsService orderItemsService){
        this.orderItemsService = orderItemsService;
    }

    @PostMapping("/v1/add")
    public ResponseEntity<String>createOrederItem(@RequestBody CreateOrderItemsDto data){
    String message = orderItemsService.addOrderItem(data.orderItms_Id(),
            data.ord_qty(),
            data.orders(),
            data.product());
    return  ResponseEntity.status(201).body(message);
    }

    @GetMapping("/v1/getOrderItemsById")
    public ResponseEntity<OrderItems> getOrderItemsById(@RequestParam("orderItms_Id") Integer orderItms_Id) {

        return ResponseEntity.status(200).body(orderItemsService.getOrderItemsById(orderItms_Id));
    }

    @PutMapping("/v1/updateOrderItems")
    public ResponseEntity<String> updateOrderItems(@RequestParam Integer orderItms_Id, @RequestParam Integer ord_qty) {

        return ResponseEntity.status(200).body(orderItemsService.updateOrderItems(orderItms_Id, ord_qty));
    }

    @DeleteMapping("/v1/deleteOrderItems")
    public ResponseEntity<String> deleteOrderItems(@RequestParam Integer orderItems_Id) {

        return ResponseEntity.status(200).body(orderItemsService.deleteOrderItems(orderItems_Id));
    }

    @GetMapping("/v1/checkStock")
    public ResponseEntity<String> checkStock(@RequestParam Integer pro_id, @RequestParam Integer ord_qty) {


        return ResponseEntity.status(200).body(orderItemsService.checkStock(pro_id, ord_qty
                ));
    }

    @PutMapping("/v1/reduceStock")
    public ResponseEntity<String> reduceStock(
            @RequestParam Integer pro_id,
            @RequestParam Integer ord_qty) {

        return ResponseEntity.status(200).body(orderItemsService.reduceStock(
                        pro_id,
                        ord_qty
                ));
    }

    @GetMapping("/v1/getTotalItemsInOrder")
    public ResponseEntity<String> getTotalItemsInOrder(
            @RequestParam Integer order_id) {

        return ResponseEntity.status(200).body(orderItemsService.getTotalItemsInOrder(order_id));
    }
    @GetMapping("/v1/getByOrderId")
    public ResponseEntity<List<OrderItems>> getByOrderId(@RequestParam Integer orderId) {
        return ResponseEntity.ok(orderItemsService.getByOrderId(orderId));
    }




}
