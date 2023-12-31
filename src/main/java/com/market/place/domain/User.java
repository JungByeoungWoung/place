package com.market.place.domain;

import com.market.place.utility.UtilityService;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "아이디는 Null 일 수 없습니다!")
    private String userID;
    @Column(name = "user_name")
    @NotBlank(message = "이름은 Null 일 수 없습니다!")
    private String userName;
    @Column(name = "user_pwd")
    @NotBlank(message = "패스워드는 Null 일 수 없습니다!")
    private String userPwd;

    private String userPwdcheck;
    @Column(name = "user_email")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;
    @Column(name = "create_date")
    @NotBlank
    private String createDate = UtilityService.createTimeStamp();
//    @Column(name = "address")
//    @NotBlank(message = "우편번호는 Null 일 수 없습니다!")
//    private String address;

//    @Column(name = "streetaddress")
//    @NotBlank(message = "지번 주소가 Null 값일 수 없습니다.")
//    private String streetAddress;

}
