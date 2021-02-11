package com.billion.controller;

import com.billion.entity.Cart;
import com.billion.entity.User;
import com.billion.service.OrderService;
import com.billion.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Billion
 * @create 2021/02/09 17:30
 */
public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        if(null == user){
            request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer userId = user.getId();
        String orderId = orderService.createOrder(cart, userId);
        session.setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
