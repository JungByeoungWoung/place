package com.market.place.repository;

import com.market.place.common.CustomException;
import com.market.place.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepository {
    private EntityManager em;
    public void saveUser(User user) throws CustomException {
        try {
            if (user.getUserId() != null) {
                em.persist(user);
            }
        }catch (Exception e) {
            throw new CustomException("user id 값이 null 값 입니다.");
        }
    }
}
