package com.market.place.service;

import com.market.place.common.CustomException;
import com.market.place.domain.User;
import com.market.place.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public String saveUser(User user) throws CustomException {
        userCheck(user);
        userRepository.saveUser(user);
        log.info("saveUser 유저명 : {}",user.getUserId());
        return user.getUserId();
    }

    public User findUser(String userId) {
        log.info("findUser 호출 유저 아이디 : {}", userId);
        return userRepository.findUser(userId);
    }
    /*
    * 회원가입시 기존 유저인지 미리 체크 진행
    * */
    private void userCheck(User user) {
        List<User> findUserName = userRepository.findUerList(user.getUserId());
        log.info("검색 유저 명 : {}, 유저 개수 : {}",user.getUserId(),findUserName.size());
        if (findUserName.size() < 0) {
            throw new IllegalStateException("중복 회원이 존재합니다.");
        }
    }

}
