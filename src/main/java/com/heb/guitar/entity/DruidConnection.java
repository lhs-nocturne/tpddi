package com.heb.guitar.entity;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class DruidConnection {
    private static DataSource dataSource = null;
    private volatile static DruidConnection instatce = null;
    private Connection connection = null;
    //私有构造函数,防止实例化对象
    private DruidConnection() {

    }


    /**
     * 用简单单例模式确保只返回一个链接对象
     *
     * @return
     */
    public static  DruidConnection getInstace() {
        if(instatce == null) {
            synchronized (DruidConnection.class) {
                if(instatce == null) {
                    instatce = new DruidConnection();
                }
            }
        }
        return instatce;
    }

    // 返回一个数据源
    public DataSource getDataSource() {
        return dataSource;
    }

    // 返回一个链接
    public Connection getConnection(Map properties) {
        try {
            connection = getDatasource(properties).getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 加载数据源
    private static DataSource getDatasource(Map properties) {
        DataSource source = null;
        try {
            source = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return source;
    }
}
