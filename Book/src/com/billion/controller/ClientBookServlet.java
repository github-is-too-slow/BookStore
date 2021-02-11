package com.billion.controller;

import com.billion.entity.Book;
import com.billion.entity.Page;
import com.billion.service.BookService;
import com.billion.service.impl.BookServiceImpl;
import com.billion.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Billion
 * @create 2021/02/07 19:09
 */
public class ClientBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGESIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/book?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGESIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("client/book?action=pageByPrice");
        if(request.getParameter("min") != null){
            sb.append("&min=").append(request.getParameter("min"));
        }
        if(request.getParameter("max") != null){
            sb.append("&max=").append(request.getParameter("max"));
        }
        page.setUrl(sb.toString());
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
