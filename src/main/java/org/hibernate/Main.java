package org.hibernate;

import org.hibernate.dao.UserDao;
import org.hibernate.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        List<User> users = userDao.findAllUsers();
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}