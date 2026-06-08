package com.Ecom.E_commerce.repositories;

import com.Ecom.E_commerce.models.CartItems;
import com.Ecom.E_commerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {

    List<CartItems> findByUser(User user);}
