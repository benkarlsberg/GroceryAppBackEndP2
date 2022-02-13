package com.revature.services;
import com.revature.models.CartHistory;

import java.util.List;
import java.util.Optional;

public interface CartHistoryService {
    public List<CartHistory> getAllCartHistory();
    public List <CartHistory> getOrderHistory(int userId);
    public CartHistory getCurrentCart(int userId);
}
