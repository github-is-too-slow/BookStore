package com.billion.test;

import com.billion.dao.OrderDao;
import com.billion.dao.impl.OrderDaoImpl;
import com.billion.entity.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Billion
 * @create 2021/02/09 14:31
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("1234567890", new Date(), new BigDecimal(500), 0, 21));

    }
}