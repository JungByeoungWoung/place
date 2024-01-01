package com.market.place.service;

import com.market.place.domain.User;

/**
 * 유저 관련 서비스 인터페이스
 */
public interface UserService {
    public String saveUser(User user);

    public User findUser(String userId);

//    public String userCheck(User user);

    public String validateUserId(String userId);
}
