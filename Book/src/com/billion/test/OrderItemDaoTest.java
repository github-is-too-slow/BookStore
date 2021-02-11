package com.billion.test;

import com.billion.dao.OrderItemDao;
import com.billion.dao.impl.OrderItemDaoImpl;
import com.billion.entity.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Billion
 * @create 2021/02/09 14:35
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null, "水浒传", 2, new BigDecimal(100), new BigDecimal(200), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "投资学", 1, new BigDecimal(100), new BigDecimal(100), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "现代计算机组成原理", 2, new BigDecimal(100), new BigDecimal(200), "123456789"));
    }
}