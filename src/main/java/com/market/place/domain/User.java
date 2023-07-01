package com.market.place.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "user")
@Getter @Setter
public class User {

    @GeneratedValue
    private int userNum;
    @Id
    private String userId;
    private String userName;
    private String userPwd;
    private String userEmail;
    private String createDate;
    private String address;
}
