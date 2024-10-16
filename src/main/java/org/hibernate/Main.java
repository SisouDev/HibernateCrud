package org.hibernate;

import jakarta.persistence.EntityManager;
import org.hibernate.dao.BasicDao;
import org.hibernate.dao.OrderDao;
import org.hibernate.dao.UserDao;
import org.hibernate.model.Address;
import org.hibernate.model.Order;
import org.hibernate.model.Product;
import org.hibernate.model.User;
import org.hibernate.utils.JpaUtil;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        BasicDao<User> userBasicDao = new BasicDao<>(User.class);
        BasicDao<Product> productBasicDao = new BasicDao<>(Product.class);
        BasicDao<Order> orderBasicDao = new BasicDao<>(Order.class);
        BasicDao<Address> addressBasicDao = new BasicDao<>(Address.class);

        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();

        OrderDao orderDao = new OrderDao();

        userDao.updateFirstName(5L, "Pedro Henrique");
        List<User> users = userDao.findAllUsers();

        for (User user : users) {
            System.out.println(user);
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}