package com.revature.services;

import com.revature.models.CartHistory;
import com.revature.models.CartItem;
import com.revature.repositories.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService{
    @Autowired
    CartItemRepo cir;

    @Override
    public List<CartItem> getAllCartItems() {
        return (List<CartItem>) cir.findAll();
    }

    @Override
    public List<CartItem> getPurchasedCartItems(int userId) {
        return cir.getPurchasedCartItems(userId);
    }

    @Override
    public List<CartItem> getAllCartItemsByCartHistoryId(int cartHistoryId) {
        return cir.findAllByCarthistory(cartHistoryId);
    }
}
