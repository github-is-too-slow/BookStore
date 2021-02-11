package com.billion.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 从连接池中获取和关闭Connection对象
 * @author Billion
 * @create 2021/02/03 15:24
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从连接池中获取Connection对象
     * @return
     */
    public static Connection getConnection(){
        Connection conn = conns.get();
        if(null == conn){
            try {
                conn = dataSource.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void commitAndClose(){
        Connection conn = conns.get();
        if(null != conn){
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }

    public static void rollbackAndClose(){
        Connection conn = conns.get();
        if(null != conn){
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }
}
