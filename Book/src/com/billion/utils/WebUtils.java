package com.billion.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Billion
 * @create 2021/02/05 21:19
 */
public class WebUtils {
    public static <T> T copyParametersToBean(T bean, Map parameters){
        try {
            BeanUtils.populate(bean, parameters);
        } catch (IllegalAccessException e) {
//            e.printStackTrace();
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt, int defaultInt){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultInt;
    }
}
