package com.billion.test;

import com.billion.dao.impl.BookDaoImpl;
import com.billion.entity.Book;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Billion
 * @create 2021/02/06 16:39
 */
public class BookDaoTest {
    BookDaoImpl bookDaoImpl = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDaoImpl.addBook(new Book(null, "现代操作系统", new BigDecimal(100), "Jack", 1000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDaoImpl.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookDaoImpl.updateBook(new Book(23, "现代操作系统第10版", new BigDecimal(200), "Rose", 100, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDaoImpl.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        for (Book book: bookDaoImpl.queryBooks()){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDaoImpl.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(bookDaoImpl.queryForPageItems(20, 4));
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDaoImpl.queryForPageTotalCountByPrice(10, 100));
    }

    @Test
    public void queryForPageItemsByPrice() {
        System.out.println(bookDaoImpl.queryForPageItemsByPrice(0, 4, 10, 100));
    }
}