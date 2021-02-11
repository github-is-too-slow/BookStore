package com.billion.service.impl;

import com.billion.dao.BookDao;
import com.billion.dao.impl.BookDaoImpl;
import com.billion.entity.Book;
import com.billion.entity.Page;
import com.billion.service.BookService;

import java.util.List;

/**
 * @author Billion
 * @create 2021/02/06 17:27
 */
public class BookServiceImpl implements BookService{
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        page.setItems(bookDao.queryForPageItems(begin, pageSize));
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        page.setItems(bookDao.queryForPageItemsByPrice(begin, pageSize, min, max));
        return page;
    }
}
