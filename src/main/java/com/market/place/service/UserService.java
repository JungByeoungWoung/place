package com.market.place.service;

import com.market.place.common.CustomException;
import com.market.place.domain.User;
import com.market.place.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public void saveUser(User user) throws CustomException {
        log.info("saveUser 호출 유저명 : {}",user.getUserName());
        user.setUserName(user.getUserName());
        user.setUserId(user.getUserId());
        user.setUserPwd(user.getUserPwd());
        user.setUserEmail(user.getUserEmail());
        user.setAddress(user.getAddress());
        userRepository.saveUser(user);
    }
    public User findUser(String userId) {
        log.info("findUser 호출 유저 아이디 : {}", userId);
        return userRepository.findUser(userId);
    }
}
