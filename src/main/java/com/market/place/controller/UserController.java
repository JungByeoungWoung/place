package com.market.place.controller;

import com.market.place.domain.User;
import com.market.place.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/basic/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/userAddForm")
    public String addUserForm() {
        log.info("유저 등록 페이지 호출");
        return "/basic/user/userAddForm";
    }
    @PostMapping("/userResist")
    public String userResist(@Valid @RequestBody User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.info("회원 가입 에러 발생");
            return "/basic/user/userAddForm";
        }
        userService.saveUser(user);
        return "redirect:/";
    }
    @ResponseBody
    @GetMapping("/checkId")
    public int validateUserID(String userID) {
        return userService.validateUserId(userID);
    }
}
