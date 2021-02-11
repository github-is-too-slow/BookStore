package com.billion.dao.impl;

import com.billion.dao.OrderDao;
import com.billion.entity.Order;

/**
 * @author Billion
 * @create 2021/02/09 14:23
 */
public class OrderDaoImpl extends BaseDao implements OrderDao{
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
