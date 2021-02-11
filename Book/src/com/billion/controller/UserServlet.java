package com.billion.controller;

import com.billion.entity.User;
import com.billion.service.UserService;
import com.billion.service.impl.UserServiceImpl;
import com.billion.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Billion
 * @create 2021/02/05 20:19
 */
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    protected void existsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);
        Map<String, Boolean> msg = new HashMap<>();
        msg.put("existsUsername", existsUsername);
        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(msg));
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = WebUtils.copyParametersToBean(new User(), request.getParameterMap());
        //查询用户是否存在
        user = userService.login(user);
        if(user == null){//用户不存在
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }else{//用户已存在
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (null != session) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath());
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String clientCode = request.getParameter("code");
        User user = (User) WebUtils.copyParametersToBean(new User(), request.getParameterMap());
        HttpSession session = request.getSession();
        //获取验证码
        String serverCode = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        //立即删除验证码
        session.removeAttribute(KAPTCHA_SESSION_KEY);
        //1.判断验证码是否合法
        if(null != serverCode && serverCode.equalsIgnoreCase(clientCode)){//验证码合法
            //2.判断用户名是否存在
            if(userService.existsUsername(username)){
                request.setAttribute("msg", "用户名已存在，请重新输入");
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("email", email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }else{
                userService.register(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        }else {//验证码不合法
            request.setAttribute("msg", "验证码错误");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
}
