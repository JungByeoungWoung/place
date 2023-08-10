package com.market.place.service;

import com.market.place.domain.User;
import com.market.place.domain.error.ErrorCode;
import com.market.place.exception.CustomException;
import com.market.place.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    public String saveUser(User user) {
        try {
            userCheck(user);
            userRepository.saveUser(user);
            log.info("saveUser 유저명 : {}",user.getUserID());
            return user.getUserID();
        }catch (Exception e) {
            return e.getMessage();
        }

    }

    public User findUser(String userId) {
        log.info("findUser 호출 유저 아이디 : {}", userId);
        return userRepository.findUser(userId);
    }
    public int validateUserId(String userId) {
        List<User> findUserList = userRepository.findUerList(userId);
        log.info("validateUserId --> 중복 유저 수 : {}", findUserList.size());
        if (findUserList.size() == 0 ) {
            return 2;
        }else {
            return 1;
        }
    }

    /**
     * 회원 가입 시 기존 회원인지 체크 서비스
     * @param user
     */
    public void userCheck(User user) {
        List<User> findUserName = userRepository.findUerList(user.getUserID());
        log.info("검색 유저 명 : {},  유저 개수 : {}",user.getUserID(),findUserName.size());
        if (findUserName.size() < 0) {
            throw new CustomException(ErrorCode.ERR102);
        }
    }

}
