//package com.Ecom.E_commerce.controllers;
//
//
//import com.Ecom.E_commerce.Dto.Request.CreateOrdersDto;
//import com.Ecom.E_commerce.models.Orders;
//import com.Ecom.E_commerce.services.orders_service.OrdersService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/Orders")
//
//public class OrdersController {
//    private final OrdersService ordersService;
//
//    public OrdersController(OrdersService ordersService){
//        this.ordersService = ordersService;
//    }
//
//    @PostMapping("/v1/createOrders")
//    public ResponseEntity<String >createOrders(@RequestBody CreateOrdersDto data){
//        String message = ordersService.createOrders(data.order_id(), data.total_amt(),data.user_id(), data.orderItems());
//        return ResponseEntity.status(201).body(message);
//    }
//
//    @GetMapping("/v1/getOrdersById/{orderId}")
//    public ResponseEntity<Orders> getOrdersById(@PathVariable Integer orderId) {
//        Orders order = ordersService.getOrdersById(orderId);
//        return ResponseEntity.ok(order);
//    }
//
//    @GetMapping("/v1/getAllOrders")
//    public ResponseEntity<List<Orders>> getAllOrders() {
//        return ResponseEntity.ok(ordersService.getAllOrders()
//        );
//    }
//}

package com.Ecom.E_commerce.controllers;

import com.Ecom.E_commerce.Dto.Request.CreateOrdersDto;
import com.Ecom.E_commerce.models.Orders;
import com.Ecom.E_commerce.services.orders_service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Orders")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

//    @PostMapping("/v1/createOrders")
//    public ResponseEntity<String> createOrders(
//            @RequestBody CreateOrdersDto data
//    ) {
//
//        String message = ordersService.createOrders(
//                data.order_id(),
//                data.total_amt(),
//                data.user_id()
//        );
//
//        return ResponseEntity.status(201).body(message);
//    }

    @PostMapping("/v1/createOrders")
    public ResponseEntity<String> createOrders(@RequestBody CreateOrdersDto data){

        System.out.println("Reached Controller");
        System.out.println(data);

        String message = ordersService.createOrders(
                data.order_id(),
                data.total_amt(),
                data.user_id()
        );

        return ResponseEntity.status(201).body(message);
    }

    @GetMapping("/v1/getOrdersById/{orderId}")
    public ResponseEntity<Orders> getOrdersById(
            @PathVariable Integer orderId
    ) {

        Orders order = ordersService.getOrdersById(orderId);

        return ResponseEntity.ok(order);
    }

    @GetMapping("/v1/getAllOrders")
    public ResponseEntity<List<Orders>> getAllOrders() {

        return ResponseEntity.ok(
                ordersService.getAllOrders()
        );
    }

    @PostMapping("/v1/checkout")
    public ResponseEntity<String> checkout(@RequestParam Integer userId) {
        return ResponseEntity.ok(ordersService.checkout(userId));
    }
}