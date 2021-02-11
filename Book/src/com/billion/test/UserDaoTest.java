package com.billion.test;

import com.billion.dao.impl.UserDaoImpl;
import com.billion.entity.User;
import org.junit.Test;

/**
 * @author Billion
 * @create 2021/02/03 17:56
 */
public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if(userDao.queryUserByUsername("Jack666") == null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("Jack", "Jack666") == null){
            System.out.println("用户名或密码错误，登录失败");
        }else{
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        if(userDao.saveUser(new User("Michael", "michael666", "Michael@qq.com")) == -1){
            System.out.println("注册失败");
        }else {
            System.out.println("注册成功");
        }
    }
}