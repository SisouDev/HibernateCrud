package org.hibernate;

import org.hibernate.dao.UserDao;
import org.hibernate.model.User;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = userDao.findUserById(3L);
        System.out.println(user);

        User user2 = new User("Jorge", "Armando", "jorgearm@vet.com", "@jorg@@", 'M');
        UserDao userDao2 = new UserDao();
        User user_new = userDao2.createUser(user2);
        System.out.println(user_new);
    }
}