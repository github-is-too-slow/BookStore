package com.billion.utils;

import javax.servlet.http.Cookie;

/**
 * @author Billion
 * @create 2021/02/07 22:35
 */
public class CookieUtils {
    /**
     * 根据cookie-name查找指定的cookie
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name, Cookie[] cookies){
        if(null == name || null == cookies || cookies.length == 0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
