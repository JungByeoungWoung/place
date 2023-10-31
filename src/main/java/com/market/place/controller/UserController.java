package com.market.place.controller;

import com.market.place.domain.User;
import com.market.place.service.UserService;
import com.market.place.service.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/basic/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtProvider jwtProvider;

    @GetMapping("/userAddForm")
    public String addUserForm() {
        log.info("유저 등록 페이지 호출");
        return "/basic/user/userAddForm";
    }

    /**
     * 로그인 요청
     */
    @PostMapping("/userResist")
    public String userResist(@Valid @RequestBody User user) {
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            return "/basic/user/userAddForm";
        }
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/checkId")
    public int validateUserID(@RequestBody Map<String, String> param) {
        String userId = param.get("userId");
        log.info(">>>>> 요청 USER ID : {}", userId);
        return userService.validateUserId(userId);
    }

    @ResponseBody
    @PostMapping("/createToken")
    public String createToken(@RequestBody Map<String, String> param) {
        String userId = param.get("userId");
        String token = jwtProvider.create(userId);
        return token;
    }
}
