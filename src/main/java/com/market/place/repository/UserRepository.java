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
    private final EntityManager em;
    public void saveUser(User user) throws CustomException {
        if (user.getUserId() == null) {
            em.persist(user);
        }else {
            em.merge(user);
        }
    }
    public User findUser(String userId) {
        return em.find(User.class, userId);
    }
}
