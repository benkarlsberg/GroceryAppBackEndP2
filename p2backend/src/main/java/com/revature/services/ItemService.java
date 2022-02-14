package com.revature.services;

import com.revature.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    public List<Item> getAllItems();
    public Optional<Item> getItemById(int itemId);
    public List<Item> searchForItems(String pattern);
}
