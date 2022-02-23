package com.revature.repositories;

import com.revature.models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends CrudRepository<Item,Integer> {
//    @Query(value = "SELECT * FROM item WHERE item_name iLIKE '%:pattern%';", nativeQuery = true)
//    List<Item> searchForItems(@Param("pattern") String pattern);

    List<Item> findByItemNameContainingIgnoreCase(String pattern);
}
