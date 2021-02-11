package com.billion.dao.impl;

import com.billion.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Billion
 * @create 2021/02/03 17:00
 */
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行insert/update/delete操作
     * @param sql 执行的sql语句
     * @param args sql语句中的占位符参数
     * @return 执行未成功返回-1;
     */
    public int update(String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回一个JavaBean对象
     * @param type 返回的数据类型
     * @param sql
     * @param args
     * @param <T>
     * @return 查询失败，返回null
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回多个JavaBean对象
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return 查询失败返回null
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回一行一列值
     * @param sql
     * @param args
     * @return 查询失败返回null
     */
    public Object queryForSingleValue(String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<>(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
