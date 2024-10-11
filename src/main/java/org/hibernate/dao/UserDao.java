package org.hibernate.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.model.User;
import org.hibernate.utils.JpaUtil;

import java.util.List;

public class UserDao {
    public void updateFirstName(Long id, String firstName) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        user.setFirstName(firstName);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateLastName(Long id, String lastName) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        user.setLastName(lastName);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateEmail(Long id, String email) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        user.setEmail(email);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updatePassword(Long id, String password) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        user.setPassword(password);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateGender(Long id, Character gender) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        user.setGender(gender);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
