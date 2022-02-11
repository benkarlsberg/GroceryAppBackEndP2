package com.revature.services;

import com.revature.models.CartItem;
import com.revature.repositories.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartItemServiceImpl implements CartItemService{
    @Autowired
    CartItemRepo cir;
    @Override
    public List<CartItem> getAllCartItems() {
        return (List<CartItem>) cir.findAll();
    }
}
