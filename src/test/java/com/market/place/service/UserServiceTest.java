package com.market.place.service;

import com.market.place.common.CustomException;
import com.market.place.domain.User;
import com.market.place.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Test
    void userIDValidateCheck() throws CustomException {
        //given
        User user = new User();
        user.setUserNum(1);
        user.setUserName("test");
        user.setUserPwd("test");
        user.setUserID("test");
        //when
        userRepository.saveUser(user);
        //then
        assertEquals(1, userService.validateUserId("test"));
    }
}