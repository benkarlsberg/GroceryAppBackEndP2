package com.revature.repositories;

import com.revature.models.CartHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartHistoryRepo extends CrudRepository<CartHistory, Integer> {
     @Query(value = "SELECT * FROM cart_history WHERE cart_history_id=? AND date IS NOT NULL;", nativeQuery = true)
     List<CartHistory> getAllCartHistory(int id);

     @Query(value = "SELECT * FROM cart_history WHERE user_id=? AND date IS NULL;", nativeQuery = true)
     CartHistory getCurrentCart(int id);
}
