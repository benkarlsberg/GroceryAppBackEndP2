package com.revature.services;

import com.revature.models.CartHistory;
import com.revature.repositories.CartHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartHistoryServiceImpl implements CartHistoryService{
    @Autowired
    CartHistoryRepo chr;

    @Override
    public List<CartHistory> getAllCartHistory() {
        return (List<CartHistory>) chr.findAll();
    }

    @Override
    public List <CartHistory> getAllCartHistory(int userId) {
        return chr.getAllCartHistory(userId);
    }

    @Override
    public CartHistory getCurrentCart(int userId){
        return chr.getCurrentCart(userId);
    }

    @Override
    public CartHistory addCartHistory(CartHistory cartHistory) {
        return chr.save(cartHistory);
    }

    @Override
    public CartHistory updateCartHistory(CartHistory change) {
        return chr.save(change);
    }

    @Override
    public boolean deleteCartHistory(int id) {
        try {
            chr.deleteById(id);
            return true;
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }


}
