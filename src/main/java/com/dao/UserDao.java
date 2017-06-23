package com.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository  
public class UserDao {
	private DataSource dataSource;  
    private JdbcTemplate jdbcTemplate;  
  
    @Autowired  
    public void setDataSource(DataSource dataSource) {  
        this.dataSource = dataSource;  
        this.jdbcTemplate = new JdbcTemplate(dataSource);  
    }  
  
    public int addUser(User user) {  
        String name = user.getName();  
        String password = user.getPassword();  
        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);  
        int result = jdbcTemplate.update("insert into user(name, password) values(?,?)",name, password);  
        return result;  
    }  
  
    public User findOneUser(int id) {  
        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);  
        User user = jdbcTemplate.queryForObject("select id, name, password from user where id = ?", mapper, id);  
        return user;  
    }  
  
    public User findUserByName(String name) {  
        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);  
        User user = jdbcTemplate.queryForObject("select id, name, password from user where name = ?", mapper, name);  
        return user;  
    }  
}
