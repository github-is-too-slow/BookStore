package com.billion.service;

import com.billion.entity.Cart;

/**
 * @author Billion
 * @create 2021/02/09 15:31
 */
public interface OrderService {
    String createOrder(Cart cart, Integer userId);
}
