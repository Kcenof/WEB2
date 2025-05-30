package com.example.project.controller;

import com.example.project.model.Item;
import com.example.project.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:5173")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping
    public List<Item> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return repository.save(item);
    }
}
