package com.market.place.controller;

import com.market.place.common.CustomException;
import com.market.place.domain.User;
import com.market.place.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@RequiredArgsConstructor
class UserControllerTest {
    private UserService userservice;
    @Test
    void userResist() throws CustomException {
        //given
        User user = new User();
        user.setUserNum(1);
        user.setUserId("testUser");
        user.setUserPwd("123");
        //when
        userservice.saveUser(user);
        //then

    }
}