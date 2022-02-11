package com.revature.services;

import com.revature.models.CartHistory;
import com.revature.repositories.CartHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartHistoryServiceImpl implements CartHistoryService{
    @Autowired
    CartHistoryRepo chr;

    @Override
    public List<CartHistory> getAllCartHistory() {
        return (List<CartHistory>) chr.findAll();
    }
}
