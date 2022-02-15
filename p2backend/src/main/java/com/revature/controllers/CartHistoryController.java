package com.revature.controllers;

import com.revature.models.CartHistory;
import com.revature.models.CartHistory;
import com.revature.services.CartHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartHistoryController {

    @Autowired
    CartHistoryService chs;

    @GetMapping("/carthistory")
    public List<CartHistory> getAllCartHistory() {
        return chs.getAllCartHistory();
    }

    @GetMapping("/carthistory/{userId}")
    public List<CartHistory> getAllCartHistory(@PathVariable("userId") String userId) {
        return chs.getAllCartHistory(Integer.parseInt("userId"));
    }

    @GetMapping("/carthistory/current/{userId}")
    public CartHistory getCurrentCart(@PathVariable("userId") String userId) {
        return chs.getCurrentCart(Integer.parseInt(userId));
    }

    @PostMapping(value = "/carthistory", consumes = "application/json", produces = "application/json")
    public CartHistory addCartHistory(@RequestBody CartHistory cartHistory) {
        return chs.addCartHistory(cartHistory);
    }

    @PutMapping(value="/carthistory/{id}", consumes = "application/json", produces = "application/json")
    public CartHistory updateCartHistory(@PathVariable("id") String id, @RequestBody CartHistory cartHistory) {
        cartHistory.setId(Integer.parseInt(id));
        return chs.updateCartHistory(cartHistory);
    }

    @DeleteMapping("carthistory/{id}")
    public ResponseEntity<CartHistory> deleteCartHistory(@PathVariable("id") String id) {
        boolean success = chs.deleteCartHistory(Integer.parseInt(id));
        return new ResponseEntity<>((success) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }
}
