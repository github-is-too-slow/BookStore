package com.billion.test;

import com.billion.entity.Cart;
import com.billion.entity.CartItem;
import com.billion.service.OrderService;
import com.billion.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Billion
 * @create 2021/02/09 17:10
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        OrderService orderService = new OrderServiceImpl();
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "时间简史", 1, new BigDecimal(100)));
        cart.addItem(new CartItem(2, "时间简史2", 2, new BigDecimal(100)));
        cart.addItem(new CartItem(3, "时间简史3", 3, new BigDecimal(100)));
        System.out.println(orderService.createOrder(cart, 21));
    }
}