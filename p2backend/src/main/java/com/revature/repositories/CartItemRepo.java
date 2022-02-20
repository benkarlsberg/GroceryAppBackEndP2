package com.revature.repositories;

import com.revature.models.CartItem;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo extends CrudRepository<CartItem,Integer> {
    @Query(value = "SELECT * FROM cart_item ci INNER JOIN (SELECT * FROM cart_history WHERE user_id=? AND date IS NOT NULL) ch ON ci.cart_history_id=ch.cart_history_id;", nativeQuery = true)
    public List<CartItem> getPurchasedCartItems(int userId);

    @Query(value = "SELECT * FROM cart_item WHERE cart_history_id=?;", nativeQuery = true)
    public List<CartItem> findAllByCartHistory(int cartHistoryId);
}
