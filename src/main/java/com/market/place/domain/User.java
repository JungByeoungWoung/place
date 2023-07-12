package com.market.place.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "User")
@Getter @Setter
public class User {
    /*
    * @Generatedvalue로 pk 생성,
    * identity를 사용하여 auto increment
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_num")
    private int userNum;

    @Column(name = "user_id")
    private String userID;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_pwd")
    private String userPwd;
    private String userPwdcheck;
    @Column(name = "user_email")
    private String email;
    @Column(name = "create_date")
    private String createDate;
    @Column(name = "address")
    private String address;
}
