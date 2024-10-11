package org.hibernate;

import org.hibernate.dao.BasicDao;
import org.hibernate.dao.UserDao;
import org.hibernate.model.Product;
import org.hibernate.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        BasicDao<User> userBasicDao = new BasicDao<>(User.class);
        BasicDao<Product> productBasicDao = new BasicDao<>(Product.class);

        List<User> users = userBasicDao.findAll();
        for (User user1 : users) {
            System.out.println(user1);
        }

    }
}