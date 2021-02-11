package com.billion.dao;

import com.billion.entity.Order;

/**
 * @author Billion
 * @create 2021/02/09 14:21
 */
public interface OrderDao {
    int saveOrder(Order order);
}
