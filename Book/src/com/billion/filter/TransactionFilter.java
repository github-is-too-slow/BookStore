package com.billion.filter;

import com.billion.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Billion
 * @create 2021/02/10 15:31
 */
public class TransactionFilter implements Filter{

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();
            throw new RuntimeException(e);
        }
    }
}
