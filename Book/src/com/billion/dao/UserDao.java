package com.billion.dao;

import com.billion.entity.User;

/**
 * @author Billion
 * @create 2021/02/03 17:37
 */
public interface UserDao {

    /**
     * 根据用户名查询用户
     * @param username
     * @return 查询失败返回null
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return 查询失败返回null
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return 保存失败返回-1
     */
    int saveUser(User user);
}
