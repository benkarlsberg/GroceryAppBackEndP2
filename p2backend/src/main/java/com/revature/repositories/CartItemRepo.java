package com.revature.repositories;

import com.revature.models.CartItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo extends CrudRepository<CartItem,Integer> {
    @Query(value = "SELECT * FROM cart_item ci INNER JOIN (SELECT * FROM cart_history WHERE user_id=? AND date!=null) ch ON ci.cart_history_id=ch.cart_history_id;", nativeQuery = true)
    public List<CartItem> getPurchasedCartItems(int userId);
}
