package com.revature.controllers;

import com.revature.models.CartHistory;
import com.revature.services.CartHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartHistoryController {

    @Autowired
    CartHistoryService chs;

    @GetMapping("/carthistory")
    public List<CartHistory> getAllCartHistory() {
        return chs.getAllCartHistory();
    }
}
