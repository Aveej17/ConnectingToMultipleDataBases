package com.jj.connectingMultipleDataBases.repository;


import com.jj.connectingMultipleDataBases.model.Testing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;



    // Doubt in creating Table using Namedjdbctemplate // Manually create a table in sql crud operations are working fine.


//    TestRepository(NamedParameterJdbcTemplate jdbcTemplate){
//
//        String sql = "CREATE TABLE IF NOT EXIST testing (id int, value1 VARCHAR(25))";
//
//// create a Map object that maps the named parameters to their values
//        Map<String, Object> params = new HashMap<>();
//        params.put("id","int");
//        params.put("value1", "varchar(25)");
//
//
//// call the update method of NamedParameterJdbcTemplate
//        this.jdbcTemplate.update(sql, params);
//    }

    TestRepository(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        createTable();
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS testing (id int, value1 VARCHAR(25))";

        // create a Map object that maps the named parameters to their values
        Map<String, Object> params = new HashMap<>();
        params.put("id", "int");
        params.put("value1", "varchar(25)");

        // call the update method of NamedParameterJdbcTemplate
        this.jdbcTemplate.update(sql, params);
    }


    public List<Testing> getTest() {
        return jdbcTemplate.query("select * from testing",
        new RowMapper<>() {
            @Override
            public Testing mapRow(ResultSet rs, int rowNum) throws SQLException {
                Testing t =new Testing(rs.getInt("id"),rs.getString("value"));
                return t;
            }
        });
    }

    public int insertTest(Testing t) {
        MapSqlParameterSource mapSqlParameterSource =new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id" , t.getId());
        mapSqlParameterSource.addValue("value", t.getValue());
        return jdbcTemplate.update("insert into testing (id,value) values(:id, :value)",mapSqlParameterSource);
    }

    public int updateTest(int id, String value) {
        MapSqlParameterSource mapSqlParameterSource =new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id" , id);
        mapSqlParameterSource.addValue("value", value);
        return jdbcTemplate.update("update testing set value=:value where id=:id",mapSqlParameterSource);
    }

    public int deleteTest(int id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return jdbcTemplate.update("Delete from testing where id=:id", parameterSource);
    }
}
