package com.example.adminapp.controller;

import com.example.adminapp.model.Item;
import com.example.adminapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository repository;

    @GetMapping
    public String listItems(Model model) {
        model.addAttribute("items", repository.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String newItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "item-form";
    }

    @PostMapping
    public String saveItem(@ModelAttribute Item item) {
        repository.save(item);
        return "redirect:/items";
    }

    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        model.addAttribute("item", repository.findById(id).orElseThrow());
        return "item-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/items";
    }
}
