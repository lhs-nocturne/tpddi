package com.heb.guitar.utils;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DBPool {

    private final static Map dataSourceCache = new ConcurrentHashMap<String, DataSource>();
    private final static Map jdbcTemplateCache = new ConcurrentHashMap<String, NamedParameterJdbcTemplate>();

    private DBPool(){
    }

    public static synchronized void createDBPoolCache(String key,DataSource dataSource){
        dataSourceCache.put(key,dataSource);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        jdbcTemplateCache.put(key,jdbcTemplate);
        return;
    }

    public static DataSource getDataSourceCache(String dataSourceId){
        return (DataSource) dataSourceCache.get(dataSourceId);
    }

    public static NamedParameterJdbcTemplate getJdbcTemplateCache(String dataSourceId){
        return (NamedParameterJdbcTemplate) jdbcTemplateCache.get(dataSourceId);
    }


}
