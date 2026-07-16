package com.appdev.firstcrud.service;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.appdev.firstcrud.entity.ItemEntity;
import com.appdev.firstcrud.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository irepo;

    // Resolves java:S6813 and JAVA_CONSTRUCTOR_PARAMETER_INJECTION
    public ItemService(ItemRepository irepo) {
        this.irepo = irepo;
    }

    // C - Create
    public ItemEntity postItem(@NonNull ItemEntity item) {
        return irepo.save(item);
    }

    // R - Read
    public List<ItemEntity> getAllItems() {
        return irepo.findAll();
    }

    // U - Update
    public ItemEntity putItem(int id, ItemEntity newItemDetails) {
        // Safe retrieve without using a return statement inside a finally block
        ItemEntity item = irepo.findById(id)
            .orElseThrow(() -> new NameNotFoundException("Item " + id + " does not exist!"));

        item.setName(newItemDetails.getName());
        item.setUnit(newItemDetails.getUnit());
        item.setPrice(newItemDetails.getPrice());

        return irepo.save(item);
    }

    // D - Delete
    public String deleteItem(int id) {
        if (irepo.existsById(id)) {
            irepo.deleteById(id);
            return "Item " + id + " is successfully deleted!";
        } else {
            return id + " does not exist!";
        }
    }
}