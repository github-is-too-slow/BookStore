package com.billion.dao;

import com.billion.entity.OrderItem;

/**
 * @author Billion
 * @create 2021/02/09 14:22
 */
public interface OrderItemDao {
    int saveOrderItem(OrderItem orderItem);
}
