package com.appdev.firstcrud.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.firstcrud.entity.ItemEntity;
import com.appdev.firstcrud.service.ItemService;

@RestController
@RequestMapping("/item/api")
@CrossOrigin(origins = "http://localhost:3000")
@SuppressWarnings({"java:S4684", "null"}) 
public class ItemController {

    private final ItemService iserv;

    public ItemController(ItemService iserv) {
        this.iserv = iserv;
    }

    @GetMapping("/printAuthor")
    public String printAuthor() {
        return "Leah V. Barbaso";
    }

    // C - Create
    @PostMapping(value = "/postNewItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemEntity postItem(@RequestBody ItemEntity item) {
        return iserv.postItem(item);
    }

    // R - Read
    @GetMapping(value = "/getAllItems", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemEntity> getAllItems() {
        return iserv.getAllItems();
    }

    // U - Update
    // Use path variable for clarity: PUT /item/api/putItem/{id}
    @PutMapping(value = "/putItem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemEntity putItem(@PathVariable int id, @RequestBody ItemEntity newItemDetails) {
        return iserv.putItem(id, newItemDetails);
    }

    // D - Delete
    @DeleteMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable int id) {
        return iserv.deleteItem(id);
    }
}