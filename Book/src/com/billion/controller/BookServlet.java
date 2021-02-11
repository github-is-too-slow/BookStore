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
 * @create 2021/02/06 17:59
 */
public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGESIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/book?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 0);
        pageNo++;
        Book book = WebUtils.copyParametersToBean(new Book(), request.getParameterMap());
        bookService.addBook(book);
        response.sendRedirect(request.getContextPath() + "/manager/book?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        bookService.deleteBookById(id);
        response.sendRedirect(request.getContextPath() + "/manager/book?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.copyParametersToBean(new Book(), request.getParameterMap());
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath() + "/manager/book?action=page&pageNo=" + request.getParameter("pageNo"));
    }

//    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Book> books = bookService.queryBooks();
//        request.setAttribute("books", books);
//        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
//    }
}
