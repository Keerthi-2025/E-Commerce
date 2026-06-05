package com.Ecom.E_commerce.services.orderitems_service;


import com.Ecom.E_commerce.exceptions.ApiRequestException;
import com.Ecom.E_commerce.mappers.OrderItemsMapper;
import com.Ecom.E_commerce.models.OrderItems;
import com.Ecom.E_commerce.models.Orders;
import com.Ecom.E_commerce.models.Product;
import com.Ecom.E_commerce.repositories.OrderItemsRepository;
import com.Ecom.E_commerce.repositories.OrdersRepository;
import com.Ecom.E_commerce.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderItemsServiceImpl implements OrderItemsService {

    private  final OrderItemsRepository orderItemsRepository;
    private final OrdersRepository ordersRepository;
    private  final OrderItemsMapper orderItemsMapper;
    private  final ProductRepository productRepository;

//    @Override
//    public String addOrderItem(Integer orderItms_Id, Integer ord_qty, Integer order_id, Integer pro_id) {
//        System.out.println("order_id = " + order_id);
//        System.out.println("pro_id = " + pro_id);
//        Orders orders = ordersRepository.findById(order_id).orElseThrow(()-> new ApiRequestException("Order not found"));
//        Product product = productRepository.findById(pro_id).orElseThrow(()-> new ApiRequestException("Product not found"));
//        if(product.getStock() < ord_qty){
//            return "Insuffiecient stock";
//        }
//        product.setStock(product.getStock() - ord_qty);
//        productRepository.save(product);
//
//        OrderItems orderItems = orderItemsMapper.tooorderitems(orderItms_Id, ord_qty, orders, product);
//
//        return "Order Item added successfully";
//    }

    @Override
    public String addOrderItem(Integer orderItms_Id,
                               Integer ord_qty,
                               Integer order_id,
                               Integer pro_id) {

        System.out.println("order_id = " + order_id);
        System.out.println("pro_id = " + pro_id);

        Orders orders = ordersRepository.findById(order_id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        System.out.println("Order Found");

        Product product = productRepository.findById(pro_id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        System.out.println("Product Found");

        OrderItems orderItems = orderItemsMapper.tooorderitems(
                orderItms_Id,
                ord_qty,
                orders,
                product
        );

//        System.out.println("Before Save");

        orderItemsRepository.save(orderItems);

//        System.out.println("After Save");

        return "Order Item Added Successfully";
    }


    @Override
    public OrderItems getOrderItemsById(Integer orderItms_Id) {
        return orderItemsRepository.findById(orderItms_Id).orElseThrow(()-> new ApiRequestException("Order ID not found"));
    }

    @Override
    public List<OrderItems> getAllOrderItems() {
        return orderItemsRepository.findAll();
    }

    @Override
    public String updateOrderItems(Integer orderItms_Id, Integer ord_qty) {
        OrderItems orderItems = orderItemsRepository.findById(orderItms_Id)
                .orElseThrow(() -> new RuntimeException("Order Item Not Found"));

        orderItems.setOrd_qty(Integer.valueOf(ord_qty));

        orderItemsRepository.save(orderItems);

        return "Order Item Updated Successfully";
    }

    @Override
    public String deleteOrderItems(Integer orderItems_Id) {
        OrderItems orderItems = orderItemsRepository.findById(orderItems_Id)
                .orElseThrow(() -> new RuntimeException("Order Item Not Found"));

        orderItemsRepository.delete(orderItems);

        return "Order Item Deleted Successfully";
    }

    @Override
    public String checkStock(Integer pro_id, Integer ord_qty) {
        Product product = productRepository.findById(pro_id)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        if (product.getStock() >= ord_qty) {
            return "Stock Available";
        }

        return "Insufficient Stock";
    }

    @Override
    public String reduceStock(Integer pro_id, Integer ord_qty) {
        Product product = productRepository.findById(pro_id)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        if (product.getStock() < ord_qty) {
            return "Insufficient Stock";
        }

        product.setStock(product.getStock() - ord_qty);

        productRepository.save(product);

        return "Stock Reduced Successfully";
    }

    @Override
    public String getTotalItemsInOrder(Integer order_id) {
        Orders orders = ordersRepository.findById(order_id)
                .orElseThrow(() -> new RuntimeException("Order Not Found"));

        List<OrderItems> items =
                orderItemsRepository.findByOrders(orders);

        int total = items.stream()
                .mapToInt(OrderItems::getOrd_qty)
                .sum();

        return String.valueOf(total);
    }
}
