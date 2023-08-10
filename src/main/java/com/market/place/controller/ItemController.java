package com.market.place.controller;

import com.market.place.domain.Item;
import com.market.place.service.ItemServiceImpl;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemServiceImpl itemServiceImpl;
    @GetMapping("/itemAddForm")
    public String addForm () {
        return "/basic/items/itemAddForm";
    }
    @PostMapping("/itemResist")
    public String insertItem(Item item) {
        itemServiceImpl.itemResist(item);
        System.out.println("=====Success Item Register=====");
        return "redirect:/";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("items", itemServiceImpl.findAll());
        System.out.println("=====Success Get Item List====");
        return "/basic/items/items";
    }

    @GetMapping("itemDelete")
    public String itemDelete(@RequestParam(value = "itemNum", required = false) List<Integer> itemNumList,
                             Model model) {
//        model.a
//        itemService.itemDelete(itemNum);
        return "/basic/items/items";
    }
}
