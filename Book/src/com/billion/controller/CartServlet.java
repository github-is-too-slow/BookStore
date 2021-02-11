package com.billion.controller;

import com.billion.entity.Book;
import com.billion.entity.Cart;
import com.billion.entity.CartItem;
import com.billion.service.BookService;
import com.billion.service.impl.BookServiceImpl;
import com.billion.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Billion
 * @create 2021/02/08 21:45
 */
public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice());
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(null == cart){
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        session.setAttribute("lastName", cartItem.getName());
//        response.sendRedirect(request.getHeader("Referer"));
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("cartTotalCount", cart.getTotalCount());
        resultMap.put("cartLastName", cartItem.getName());
        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(resultMap));
    }


    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice());
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(null == cart){
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        session.setAttribute("lastName", cartItem.getName());
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(null != cart){
            cart.deleteItem(id);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(null != cart){
            cart.clear();
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 1);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(null != cart){
            cart.updateCount(id, count);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}
