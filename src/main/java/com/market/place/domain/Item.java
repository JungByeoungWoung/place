package com.market.place.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "item")
@Getter @Setter
public class Item {
    @Id
    @GeneratedValue
    private int itemNum;

    private String userName;

    private String itemId;
    private Integer price;
    private Integer quantity;
    private String createUser;
    private String createDate;


}
