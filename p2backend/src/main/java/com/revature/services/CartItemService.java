package com.revature.services;

import com.revature.models.CartItem;

import java.util.List;

public interface CartItemService {
    public List <CartItem> getAllCartItems();
    public List <CartItem> getPurchasedCartItems(int userId);
}
