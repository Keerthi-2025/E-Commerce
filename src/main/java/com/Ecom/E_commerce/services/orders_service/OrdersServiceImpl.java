//package com.Ecom.E_commerce.services.orders_service;
//
//
//import com.Ecom.E_commerce.exceptions.ApiRequestException;
//import com.Ecom.E_commerce.mappers.OrdersMapper;
//import com.Ecom.E_commerce.models.Orders;
//import com.Ecom.E_commerce.models.User;
//import com.Ecom.E_commerce.repositories.OrdersRepository;
//import com.Ecom.E_commerce.repositories.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//
//public class OrdersServiceImpl implements OrdersService {
//    private final OrdersRepository ordersRepository;
//    private final OrdersMapper ordersMapper;
//    private final UserRepository userRepository;
//
//    public OrdersServiceImpl(OrdersRepository ordersRepository, OrdersMapper ordersMapper, UserRepository userRepository){
//        this.ordersRepository = ordersRepository;
//        this.ordersMapper = ordersMapper;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public String createOrders(Integer order_id, String total_amt, String  user_id, List<Integer> orderItems) {
//        User user = userRepository.findById(user_id).orElseThrow(()-> new ApiRequestException("User not found"));
//        Orders orders = ordersMapper.toorders(order_id, total_amt, user, orderItems);
//        ordersRepository.save(orders);
//        return "Order created successfully";
//    }
//
//    @Override
//    public Orders getOrdersById(Integer order_id) {
//        return ordersRepository.findById(order_id).orElseThrow(()-> new ApiRequestException("Order ID not found"));
//    }
//
//    @Override
//    public List<Orders> getAllOrders() {
//        return ordersRepository.findAll();
//    }
//
//    @Override
//    public List<Orders> findByUser(User user) {
//        return List.of();
//    }
//}

package com.Ecom.E_commerce.services.orders_service;

import com.Ecom.E_commerce.exceptions.ApiRequestException;
import com.Ecom.E_commerce.mappers.OrdersMapper;
import com.Ecom.E_commerce.models.Orders;
import com.Ecom.E_commerce.models.User;
import com.Ecom.E_commerce.repositories.OrdersRepository;
import com.Ecom.E_commerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersMapper ordersMapper;
    private final UserRepository userRepository;

    public OrdersServiceImpl(
            OrdersRepository ordersRepository,
            OrdersMapper ordersMapper,
            UserRepository userRepository
    ) {
        this.ordersRepository = ordersRepository;
        this.ordersMapper = ordersMapper;
        this.userRepository = userRepository;
    }

    @Override
    public String createOrders(
            Integer order_id,
            String total_amt,
            String user_id
    ) {

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new ApiRequestException("User not found"));

        Orders orders = ordersMapper.toorders(
                order_id,
                total_amt,
                user
        );

        ordersRepository.save(orders);

        return "Order created successfully";
    }

    @Override
    public Orders getOrdersById(Integer order_id) {
        return ordersRepository.findById(order_id)
                .orElseThrow(() -> new ApiRequestException("Order ID not found"));
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public List<Orders> findByUser(User user) {
        return ordersRepository.findByUser(user);
    }
}