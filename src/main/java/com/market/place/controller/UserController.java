package com.market.place.controller;

import com.market.place.common.error.CustomException;
import com.market.place.common.error.ErrorCode;
import com.market.place.domain.User;
import com.market.place.domain.UserResVo;
import com.market.place.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/basic/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = RequestMethod.POST)
public class UserController {
    private final UserService userService;

    /**
     * 로그인 요청
     */
    @PostMapping("/userResist")
    public UserResVo userResist(@Valid @RequestBody User user) {
        UserResVo res = new UserResVo();
        try {

            String userId = userService.saveUser(user);
            if (userId.equals("fail")) {
                res.setResultCode("01");
                res.setResultMessage("중복 회원");
            }else {
                log.info("회원 가입 유저 ID : {}", userId);
                res.setResultCode("00");
                res.setResultMessage("Success");
            }
        } catch (Exception e) {
            throw new CustomException("Failed Register User", ErrorCode.REGISTER_FAILED);
        }
        return res;
    }

    @ResponseBody
    @PostMapping("/userCheckId")
    public UserResVo validateUserID(@RequestBody Map<String, String> param) {
        UserResVo res = new UserResVo();
        String userId = param.get("userID");
        log.info(">>>>> 요청 USER ID : {}", userId);
        String result = userService.validateUserId(userId);
        if (result == "00") {
            res.setResultCode(result);
            res.setResultMessage("중복 아이디가 아닙니다.");
        }else {
            res.setResultCode(result);
            res.setResultMessage("중복된 아이디 입니다.");
        }
        return res;
    }
}
