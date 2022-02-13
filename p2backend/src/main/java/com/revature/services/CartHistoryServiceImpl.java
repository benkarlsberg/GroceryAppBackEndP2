package com.revature.services;

import com.revature.models.CartHistory;
import com.revature.repositories.CartHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartHistoryServiceImpl implements CartHistoryService{
    @Autowired
    CartHistoryRepo chr;

    @Override
    public List<CartHistory> getAllCartHistory() {
        return (List<CartHistory>) chr.findAll();
    }

    @Override
    public List <CartHistory> getOrderHistory(int userId) {
        return chr.getOrderHistory(userId);
    }


}
