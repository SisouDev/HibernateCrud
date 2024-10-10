package org.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.model.User;
import org.hibernate.utils.JpaUtil;

import java.util.List;

public class UserDao {

    public User createUser(User user) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    public User findUserById(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

    public List<User> findAllUsers() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setMaxResults(5);
        List<User> users = query.getResultList();
        entityManager.close();
        return users;
    }


}
