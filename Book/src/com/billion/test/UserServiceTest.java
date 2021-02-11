package com.billion.test;

import com.billion.entity.User;
import com.billion.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author Billion
 * @create 2021/02/03 19:26
 */
public class UserServiceTest {
    UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void register() {
        if(userService.register(new User("Zhangsan", "zhangsan666", "Zhangsan@qq.com")) == -1){
            System.out.println("注册失败");
        }else {
            System.out.println("注册成功");
        }
    }

    @Test
    public void login() {
        if(userService.login(new User("Jack", "jack", null)) == null){
            System.out.println("登录失败");
        }else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("Michael")){
            System.out.println("用户名存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}