package com.heb.guitar.utils;

import com.heb.guitar.entity.DsmDatasource;
import com.heb.guitar.entity.DsmDatasourceType;
import java.sql.*;

public class DBUtil {

    public static Connection getConnection(DsmDatasource dsmDatasoure, DsmDatasourceType dsDatasourceType) {
        if(dsmDatasoure.getJdbcUrl()==null||dsmDatasoure.getJdbcUrl().equals("")) {
            String url="jdbc:";
            if(dsDatasourceType.getDriverClass().contains("dm")){
                url+="dm://"+dsmDatasoure.getHost()+":"+dsmDatasoure.getPort();
                if(dsmDatasoure.getSchemaName()!=null&&!dsmDatasoure.getSchemaName().equals("")){
                    url+="?schema="+dsmDatasoure.getSchemaName();
                }
            }else if(dsDatasourceType.getDriverClass().contains("mysql")){
                url+="mysql://"+dsmDatasoure.getHost()+":"+dsmDatasoure.getPort()+"/"+dsmDatasoure.getSchemaName()+"?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
            }else if(dsDatasourceType.getDriverClass().contains("oracle")){
                url+="oracle:thin:@//"+dsmDatasoure.getHost()+":"+dsmDatasoure.getPort()+"/"+dsmDatasoure.getSchemaName();
            }else if (dsDatasourceType.getDriverClass().contains("sqlserver")){
                url+="sqlserver://"+dsmDatasoure.getHost()+":"+dsmDatasoure.getPort()+";DatabaseName="+dsmDatasoure.getSchemaName();
            }
            dsmDatasoure.setJdbcUrl(url);
        }
        Connection conn = null;
        //加载驱动类
        try {
            Class.forName(dsDatasourceType.getDriverClass());
            conn= DriverManager.getConnection(dsmDatasoure.getJdbcUrl(),dsmDatasoure.getUsername(),dsmDatasoure.getPassword());
            return conn;
        }catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 关闭连接释放内存
     * @param rs
     * @param ps
     * @param conn
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
