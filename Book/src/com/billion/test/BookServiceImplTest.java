package com.billion.test;

import com.billion.service.BookService;
import com.billion.service.impl.BookServiceImpl;
import org.junit.Test;

/**
 * @author Billion
 * @create 2021/02/07 15:37
 */
public class BookServiceImplTest {
    BookService bookService = new BookServiceImpl();
    @Test
    public void page() {
        System.out.println(bookService.page(6, 4));
    }

    @Test
    public void pageByPriceTest() {
        System.out.println(bookService.pageByPrice(0, 4, 10, 100));
    }

    @Test
    public void parseIntTest(){
        try {
            System.out.println(Integer.parseInt(""));
        } catch (NumberFormatException e) {
            System.out.println("解析错误");
        }
    }
}