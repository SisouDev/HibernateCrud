package org.hibernate;

import org.hibernate.dao.UserDao;
import org.hibernate.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        userDao.updateName(5L, "Leo", "Leonardo");
        userDao.updateEmailPassword(5L, "leonardo@gmail.com", "123546");

        List<User> users = userDao.findAllUsers();
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}