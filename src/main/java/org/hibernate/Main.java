package org.hibernate;

import jakarta.persistence.EntityManager;
import org.hibernate.dao.BasicDao;
import org.hibernate.dao.UserDao;
import org.hibernate.model.Addresses;
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
        BasicDao<Addresses> addressBasicDao = new BasicDao<>(Addresses.class);

        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();


        List<Order> orders = orderBasicDao.findAll();

       for (Order order : orders) {
           Hibernate.initialize(order.getProducts());
           System.out.println(order);
       }
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}