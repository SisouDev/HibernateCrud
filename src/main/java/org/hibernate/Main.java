package org.hibernate;

import org.hibernate.dao.BasicDao;
import org.hibernate.dao.UserDao;
import org.hibernate.model.Addresses;
import org.hibernate.model.Order;
import org.hibernate.model.Product;
import org.hibernate.model.User;
import org.hibernate.utils.enums.ORDER_STATUS;
import org.hibernate.utils.enums.PRODUCT_TYPE;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        BasicDao<User> userBasicDao = new BasicDao<>(User.class);
        BasicDao<Product> productBasicDao = new BasicDao<>(Product.class);
        BasicDao<Order> orderBasicDao = new BasicDao<>(Order.class);
        BasicDao<Addresses> addressBasicDao = new BasicDao<>(Addresses.class);

       List<Order> orders = orderBasicDao.findAll();

       for (Order order : orders) {
           System.out.println(order);
       }


    }
}