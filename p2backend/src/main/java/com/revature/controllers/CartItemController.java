package com.revature.controllers;

import com.revature.models.CartItem;
import com.revature.models.Item;
import com.revature.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CartItemController {

    @Autowired
    CartItemService cis;

    @GetMapping("/cartitem")
    public List<CartItem> getAllCartItems() {
        return cis.getAllCartItems();
    }

    @GetMapping("/cartitem/purchasehistory/{userId}")
    public List<CartItem> getPurchasedCartItems(@PathVariable("userId") String userId) {
        return cis.getPurchasedCartItems(Integer.parseInt(userId));
    }

    @GetMapping("/cartitem/{cartHistoryId}")
    public List<CartItem> getAllCartItemsByCartHistoryId(@PathVariable("cartHistoryId") String cartHistoryId) {
        return cis.getAllCartItemsByCartHistoryId(Integer.parseInt(cartHistoryId));
    }

    @PostMapping(value = "/cartitem", consumes = "application/json", produces = "application/json")
    public CartItem addCartItem(@RequestBody CartItem cartItem) {
        return cis.addCartItem(cartItem);
    }

    @PutMapping(value="/cartitem/{id}", consumes = "application/json", produces = "application/json")
    public CartItem updateCartItem(@PathVariable("id") String id, @RequestBody CartItem cartItem) {
        cartItem.setId(Integer.parseInt(id));
        return cis.updateCartItem(cartItem);
    }

    @DeleteMapping("cartitem/{id}")
    public ResponseEntity<CartItem> deleteCartItem(@PathVariable("id") String id) {
        boolean success = cis.deleteCartItem(Integer.parseInt(id));
        return new ResponseEntity<>((success) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }
}
