package com.billion.service.impl;

import com.billion.dao.BookDao;
import com.billion.dao.OrderDao;
import com.billion.dao.OrderItemDao;
import com.billion.dao.impl.BookDaoImpl;
import com.billion.dao.impl.OrderDaoImpl;
import com.billion.dao.impl.OrderItemDaoImpl;
import com.billion.entity.*;
import com.billion.service.OrderService;

import java.util.Date;

/**
 * @author Billion
 * @create 2021/02/09 15:34
 */
public class OrderServiceImpl implements OrderService{
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
//        int singlePrice = 12 / 0;
        for (CartItem cartItem: cart.getItems().values()){
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
            Integer bookId = cartItem.getId();
            Book book = bookDao.queryBookById(bookId);
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }
}
