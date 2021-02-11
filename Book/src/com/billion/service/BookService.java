package com.billion.service;

import com.billion.entity.Book;
import com.billion.entity.Page;

import java.util.List;

/**
 * @author Billion
 * @create 2021/02/06 17:26
 */
public interface BookService {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
