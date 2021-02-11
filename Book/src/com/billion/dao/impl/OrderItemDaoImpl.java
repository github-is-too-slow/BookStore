package com.billion.dao.impl;

import com.billion.dao.OrderItemDao;
import com.billion.entity.OrderItem;

/**
 * @author Billion
 * @create 2021/02/09 14:27
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao{
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
