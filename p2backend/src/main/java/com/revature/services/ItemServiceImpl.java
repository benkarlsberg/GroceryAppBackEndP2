package com.revature.services;

import com.revature.models.Item;
import com.revature.repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepo ir;
    @Override
    public List<Item> getAllItems() {
        return (List<Item>) ir.findAll();
    }
}