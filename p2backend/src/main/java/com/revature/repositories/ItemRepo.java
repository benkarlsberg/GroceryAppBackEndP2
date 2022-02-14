package com.revature.repositories;

import com.revature.models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends CrudRepository<Item,Integer> {
    @Query(value = "SELECT * FROM items WHERE item_name LIKE %?%;", nativeQuery = true)
    List<Item> searchForItems(String pattern);
}
