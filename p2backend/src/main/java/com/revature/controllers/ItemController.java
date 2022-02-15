package com.revature.controllers;

import com.revature.models.Item;
import com.revature.models.User;
import com.revature.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {

    @Autowired
    ItemService is;

    @GetMapping("/item")
    public List<Item> getAllItems() {
        return is.getAllItems();
    }

    @GetMapping("/item/{id}")
    public Optional<Item> getItemById(@PathVariable("id") String id) {
        return is.getItemById(Integer.parseInt(id));
    }

    @GetMapping("/item/search/{pattern}")
    public List<Item> searchForItems(@PathVariable("pattern") String pattern){
        return is.searchForItems(pattern);
    }

    @PostMapping(value = "/item", consumes = "application/json", produces = "application/json")
    public Item addItem(@RequestBody Item item) {
        return is.addItem(item);
    }

    @PutMapping(value="/item/{id}", consumes = "application/json", produces = "application/json")
    public Item updateItem(@PathVariable("id") String id, @RequestBody Item item) {

        item.setId(Integer.parseInt(id));
        return is.updateItem(item);
    }

    @DeleteMapping("item/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable("id") String id) {
        boolean success = is.deleteItem(Integer.parseInt(id));
        return new ResponseEntity<>((success) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }
}
