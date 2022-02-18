package com.revature.services;
import com.revature.models.CartHistory;

import java.util.List;

public interface CartHistoryService {
    public List<CartHistory> getAllCartHistory();
    public List <CartHistory> getAllCartHistory(int userId);
    public CartHistory getCurrentCart(int userId);
    public CartHistory addCartHistory(CartHistory cartHistory);
    public CartHistory updateCartHistory(CartHistory change);
    public boolean deleteCartHistory(int id);
}
