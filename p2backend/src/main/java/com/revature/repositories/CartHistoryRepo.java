package com.revature.repositories;

import com.revature.driver.models.CartHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartHistoryRepo extends CrudRepository<CartHistory, Integer> {
}
