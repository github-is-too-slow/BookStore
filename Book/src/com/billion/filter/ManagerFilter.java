package com.billion.filter;

import com.billion.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Billion
 * @create 2021/02/09 23:21
 */
public class ManagerFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(null == user){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest, servletResponse);
            return;
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
