package com.jj.connectingMultipleDataBases;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBBean {

    @Bean
    public Connection getDB() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flight", "root", "0000");
        return con;
    }

    @Bean
    public DataSource getconnection(){
        DataSourceBuilder<?> ds = DataSourceBuilder.create();
        ds.url("jdbc:mysql://localhost:3306/mydb");
        ds.username("root");
        ds.password("0000");
        return ds.build();
    }
}
