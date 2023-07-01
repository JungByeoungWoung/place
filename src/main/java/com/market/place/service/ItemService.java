package com.market.place.service;

import com.market.place.domain.Item;
import com.market.place.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemMapper itemMapper;

    public void itemResist(Item item) {
        item.setItemId(item.getItemId());
        item.setUserName(item.getUserName());
        item.setPrice(item.getPrice());
        item.setQuantity(item.getQuantity());
        item.setCreateUser(item.getCreateUser());

        itemMapper.insertItem(item);
    }

    public List<Item> findAll() {
        return itemMapper.findAll();
    }

    public void itemDelete(int itemNum) {
        itemMapper.deleteItem(itemNum);
        System.out.println("itemNum : " + itemNum);
    }
}
