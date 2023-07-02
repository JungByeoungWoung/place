package com.market.place.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "user")
@Getter @Setter
public class User {

    @GeneratedValue
    @Column(name = "user_num")
    private int userNum;
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_pwd")
    private String userPwd;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "create_date")
    private String createDate;
    @Column(name = "address")
    private String address;
}
