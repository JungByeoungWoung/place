package com.market.place.controller;

import com.market.place.common.CustomException;
import com.market.place.domain.User;
import com.market.place.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/basic/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping("/userAddForm")
    public String addUserForm() {
        log.info("유저 등록 페이지 호출");
        return "/basic/user/userAddForm";
    }
    @PostMapping("/userResist")
    public String userResist(User user) throws CustomException {
        userService.saveUser(user);
        return "ok";
    }

}
