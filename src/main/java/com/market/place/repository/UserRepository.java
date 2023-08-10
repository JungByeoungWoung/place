package com.market.place.repository;

import com.market.place.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;
    /*
    * readOnly는 select에서만 사용
    * */
    @Transactional
    public void saveUser(User user) {
        if (user.getUserID() == null) {
            em.persist(user);
        }else {
            em.merge(user);
        }
    }
    public User findUser(String userId) {
        return em.find(User.class, userId);
    }
    public List<User> findUerList(String id) {
        return em.createQuery("select n from User n where n.userID = :user_id")
          .setParameter("user_id", id)
          .getResultList();
    }
}
