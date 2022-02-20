package com.revature.services;

import com.revature.models.CartHistory;
import com.revature.models.CartItem;
import com.revature.repositories.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
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
        return cir.findAllByCartHistory(cartHistoryId);
    }

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return cir.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        return cir.save(cartItem);
    }

    @Override
    public boolean deleteCartItem(int id) {
        try {
            cir.deleteById(id);
            return true;
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
