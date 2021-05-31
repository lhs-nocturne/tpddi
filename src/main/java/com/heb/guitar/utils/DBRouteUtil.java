package com.heb.guitar.utils;

import com.heb.guitar.entity.DsmDatasource;
import com.heb.guitar.entity.DsmDatasourceType;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class DBRouteUtil {

    private final static int INIT_SIZE =1;
    private final static int MIN_IDLE =1;
    private final static int MAX_IDLE =3;
    private final static int MAX_ACTIVE =5;

    private DBRouteUtil() {

    }

    public static NamedParameterJdbcTemplate getJdbcTemplate(DsmDatasource dsmDatasource, DsmDatasourceType dsmDatasourceType) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = DBPool.getJdbcTemplateCache(dsmDatasource.getDatasourceId());
        if (namedParameterJdbcTemplate == null) {
            if(dsmDatasource.getJdbcUrl()==null||dsmDatasource.getJdbcUrl().equals("")) {
                String url="jdbc:";
                if(dsmDatasourceType.getDriverClass().contains("dm")){
                    url+="dm://"+dsmDatasource.getHost()+":"+dsmDatasource.getPort();
                    if(dsmDatasource.getSchemaName()!=null&&!dsmDatasource.getSchemaName().equals("")){
                        url+="?schema="+dsmDatasource.getSchemaName();
                    }
                }else if(dsmDatasourceType.getDriverClass().contains("mysql")){
                    url+="mysql://"+dsmDatasource.getHost()+":"+dsmDatasource.getPort()+"/"+dsmDatasource.getSchemaName()+"?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
                }else if(dsmDatasourceType.getDriverClass().contains("oracle")){
                    url+="oracle:thin:@//"+dsmDatasource.getHost()+":"+dsmDatasource.getPort()+"/"+dsmDatasource.getSchemaName();
                }else if (dsmDatasourceType.getDriverClass().contains("sqlserver")){
                    url+="sqlserver://"+dsmDatasource.getHost()+":"+dsmDatasource.getPort()+";DatabaseName="+dsmDatasource.getSchemaName();
                }
                dsmDatasource.setJdbcUrl(url);
            }
            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName(dsmDatasourceType.getDriverClass());
            basicDataSource.setUrl(dsmDatasource.getJdbcUrl());
            basicDataSource.setUsername(dsmDatasource.getUsername());
            basicDataSource.setPassword(dsmDatasource.getPassword());
            basicDataSource.setInitialSize(dsmDatasource.getInitialSize() == null ? INIT_SIZE : dsmDatasource.getInitialSize());
            basicDataSource.setMinIdle(dsmDatasource.getMinIdle() == null ? MIN_IDLE : dsmDatasource.getMinIdle());
            basicDataSource.setMaxIdle(dsmDatasource.getMaxIdle() == null ? MAX_IDLE : dsmDatasource.getMaxIdle());
            basicDataSource.setMaxActive(dsmDatasource.getMaxActive() == null ? MAX_ACTIVE : dsmDatasource.getMaxActive());
            //其他属性
            DBPool.createDBPoolCache(dsmDatasource.getDatasourceId(), basicDataSource);
            namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(basicDataSource);
        }
        return namedParameterJdbcTemplate;

    }


}
