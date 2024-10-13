package org.hibernate.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import org.hibernate.model.User;
import org.hibernate.utils.JpaUtil;

import java.util.List;
import java.util.function.Consumer;

public class UserDao {

    public User getUserById(EntityManager entityManager, Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            entityManager.close();
            throw new HibernateException("User not found");
        }
        return user;
    }

    public List<User> findAllUsers(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<User> users = entityManager.createQuery("from User").getResultList();
        entityManager.close();
        return users;
    }

    public void updateUser(Long id, Consumer<User> updateFunction) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            User user = getUserById(entityManager, id);
            updateFunction.accept(user);
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public void updateFirstName(Long id, String firstName) {
        updateUser(id, s -> s.setFirstName(firstName));
    }

    public void updateLastName(Long id, String lastName) {
        updateUser(id, s -> s.setLastName(lastName));
    }

    public void updateEmail(Long id, String email) {
        updateUser(id, s -> s.setEmail(email));
    }

    public void updatePassword(Long id, String password) {
        updateUser(id, s -> s.setPassword(password));
    }

    public void updateGender(Long id, Character gender) {
        updateUser(id, s -> s.setGender(gender));
    }
}
