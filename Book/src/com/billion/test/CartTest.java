package com.billion.test;

import com.billion.entity.Cart;
import com.billion.entity.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Billion
 * @create 2021/02/08 20:56
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "时间简史", 1, new BigDecimal(100)));
        cart.addItem(new CartItem(2, "时间简史2", 2, new BigDecimal(100)));
        cart.addItem(new CartItem(3, "时间简史3", 3, new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "时间简史", 1, new BigDecimal(100)));
        cart.addItem(new CartItem(2, "时间简史2", 2, new BigDecimal(100)));
        cart.addItem(new CartItem(3, "时间简史3", 3, new BigDecimal(100)));
        cart.deleteItem(2);
        cart.addItem(new CartItem(3, "时间简史", 2, new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "时间简史", 1, new BigDecimal(100)));
        cart.addItem(new CartItem(2, "时间简史2", 2, new BigDecimal(100)));
        cart.addItem(new CartItem(3, "时间简史3", 3, new BigDecimal(100)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "时间简史", 1, new BigDecimal(100)));
        cart.addItem(new CartItem(2, "时间简史2", 2, new BigDecimal(100)));
        cart.addItem(new CartItem(3, "时间简史3", 3, new BigDecimal(100)));
        cart.updateCount(1, 3);
        System.out.println(cart);
    }
}