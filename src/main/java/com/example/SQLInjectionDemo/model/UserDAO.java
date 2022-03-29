package com.example.SQLInjectionDemo.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class UserDAO implements IUserDAO{
    private JdbcTemplate jdbcTemplate;
	private List<Student> students = new ArrayList<Student>();
	
	public UserDAO (DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public User getUser(String name, String password){
	    String sql = "SELECT * FROM users WHERE username='" + name + "' AND password ='" + password +"'";
	    return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
	    	 
	        @Override
	        public User extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                User user = new User();
	                user.setUserName(rs.getString("username"));
	                user.setPassword(rs.getString("password"));
	                return user;
	            }
	 
	            return null;
	        }
 
	    });
	}
	
	@Override
	public User checkUserById(String name){
	    String sql = "SELECT * FROM users WHERE username='" + name + "'";
	    return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
	    	 
	        @Override
	        public User extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                User user = new User();
	                user.setUserName(rs.getString("username"));
	                user.setPassword(rs.getString("password"));
	                return user;
	            }
	 
	            return null;
	        }
 
	    });
	}


	@Override
	public int addUser(User user) {
		 // insert
		  String sql = "INSERT INTO users (username, password) VALUES ('" + user.getUserName() + "', '" + user.getPassword() +"')";
		  return jdbcTemplate.update(sql);
    }
		
}
