package com.billion.service.impl;

import com.billion.dao.UserDao;
import com.billion.dao.impl.UserDaoImpl;
import com.billion.entity.User;
import com.billion.service.UserService;

/**
 * @author Billion
 * @create 2021/02/03 19:19
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();

    @Override
    public int register(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
