package com.revature.controllers;

import com.revature.models.CartItem;
import com.revature.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartItemController {

    @Autowired
    CartItemService cis;

    @GetMapping("/cartitem")
    public List<CartItem> getAllCartItems() {
        return cis.getAllCartItems();
    }
}
