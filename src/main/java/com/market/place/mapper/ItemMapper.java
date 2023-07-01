package com.market.place.mapper;

import com.market.place.domain.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemMapper {
    public void insertItem(Item item);
    public List<Item> findAll();
    public void deleteItem(int itemNum);
}
