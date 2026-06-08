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
import com.Ecom.E_commerce.models.CartItems;
import com.Ecom.E_commerce.models.OrderItems;
import com.Ecom.E_commerce.models.Orders;
import com.Ecom.E_commerce.models.User;
import com.Ecom.E_commerce.repositories.CartItemsRepository;
import com.Ecom.E_commerce.repositories.OrderItemsRepository;
import com.Ecom.E_commerce.repositories.OrdersRepository;
import com.Ecom.E_commerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersMapper ordersMapper;
    private final UserRepository userRepository;
    private final CartItemsRepository cartItemsRepository;
    private final OrderItemsRepository orderItemsRepository;

    public OrdersServiceImpl(
            OrdersRepository ordersRepository,
            OrdersMapper ordersMapper,
            UserRepository userRepository,
            CartItemsRepository cartItemsRepository,
            OrderItemsRepository orderItemsRepository
    ) {
        this.ordersRepository = ordersRepository;
        this.ordersMapper = ordersMapper;
        this.userRepository = userRepository;
        this.cartItemsRepository = cartItemsRepository;
        this.orderItemsRepository = orderItemsRepository;
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
                Double.parseDouble(total_amt),
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

    @Override
    public String checkout(Integer userId) {

        // 1. Get User object
        User user = userRepository.findById(String.valueOf(userId))
                .orElseThrow(() -> new ApiRequestException("User not found"));

        // 2. Get Cart Items using User object
        List<CartItems> cartItems = cartItemsRepository.findByUser(user);

        if (cartItems.isEmpty()) {
            throw new ApiRequestException("Cart is empty");
        }

        // 3. Calculate total
        double total = 0;
        for (CartItems item : cartItems) {
            total += item.getCar_qty() * item.getProduct().getPrice();
        }

        // 4. Create order
        Orders order = new Orders();
        order.setUser(user);
        order.setTotalAmt(String.valueOf(total));

        ordersRepository.save(order);

        // 5. Create order items
        for (CartItems item : cartItems) {

            OrderItems oi = new OrderItems();
            oi.setOrders(order);
            oi.setProduct(item.getProduct());
            oi.setOrd_qty(item.getCar_qty());

            orderItemsRepository.save(oi);
        }

        // 6. Clear cart
        cartItemsRepository.deleteAll(cartItems);

        return "Order placed successfully";
    }
}