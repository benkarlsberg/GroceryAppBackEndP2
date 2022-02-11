package com.revature.repositories;

import com.revature.models.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo extends CrudRepository<CartItem,Integer> {
}
