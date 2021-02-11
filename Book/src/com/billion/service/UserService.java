package com.billion.service;

import com.billion.entity.User;

/**
 * @author Billion
 * @create 2021/02/03 19:13
 */
public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return 返回-1注册失败
     */
    int register(User user);

    /**
     * 用户登录
     * @param user
     * @return 返回null登录失败
     */
    User login(User user);

    /**
     * 查询是否存在指定用户名
     * @param user
     * @return 返回true存在，否则不存在
     */
    boolean existsUsername(String username);
}
