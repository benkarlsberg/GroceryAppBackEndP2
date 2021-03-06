package com.revature.services;

import com.revature.models.Item;
import com.revature.repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepo ir;

    @Override
    public List<Item> getAllItems() {
        return (List<Item>) ir.findAll();
    }

    @Override
    public Optional<Item> getItemById(int itemId) {
        return ir.findById(itemId);
    }

    @Override
    public List<Item> searchForItems(String pattern) {
        return ir.findByItemNameContainingIgnoreCase(pattern);
    }

    @Override
    public Item addItem(Item item) {
        return ir.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return ir.save(item);
    }

    @Override
    public boolean deleteItem(int id) {
        try {
            ir.deleteById(id);
            return true;
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
