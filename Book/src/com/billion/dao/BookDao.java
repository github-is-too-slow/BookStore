package com.billion.dao;

import com.billion.entity.Book;

import java.util.List;

/**
 * @author Billion
 * @create 2021/02/06 16:11
 */
public interface BookDao {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
