package com.market.place.controller;

import com.market.place.common.CustomException;
import com.market.place.domain.User;
import com.market.place.repository.UserRepository;
import com.market.place.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional @Slf4j
class UserControllerTest {
    @Autowired
    private UserService userservice;
    @Test
    void userResist() throws CustomException {
        //given
        User user1 = new User();
        user1.setUserNum(1);
        user1.setUserID("testUser");
        user1.setUserPwd("123");
        //when
        String userId = userservice.saveUser(user1);
        log.info("회원 가입한 userID : {}", userId);
//        User findUserId = userservice.findUser(userId);
        //then
//        assertEquals(userId,findUserId.getUserID());
    }
}