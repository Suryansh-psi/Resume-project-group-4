package com.resume.repository;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.resume.model.User;

@Repository
public class UserRepositoryImpl implements IUserRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> getUsers() {
		String query = "select * from user";
		return jdbcTemplate.query(query, 
				(rs, rowNum) -> {
					User user = new User();
					user.setUserId(rs.getLong("user_Id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setGender(rs.getString("gender"));
					user.setDob(rs.getDate("dob"));
					return user;
				}
			);
	}
	
	
	@Override
	public Optional<User> getUserById(Long user_id) {
		String query = "select * from user where user_id= "+user_id;
		return jdbcTemplate.query(query, 
				(rs, rowNum) -> {
					User user = new User();
					user.setUserId(rs.getLong("user_Id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setGender(rs.getString("gender"));
					user.setDob(rs.getDate("dob"));
					return user;
				}
			).stream().findFirst();
	}


	@Override
	public Integer addUser(User user) {
//		String query = "INSERT INTO user(\"username\", \"password\", \"gender\", \"dob\") VALUES(? ,?, ? ,?)";
		String query = "INSERT INTO user(username, password, gender, dob) VALUES(?, ? ,?, ?)";
		
		Date now = (Date) user.getDob();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(now);
		
		return jdbcTemplate.update(query, user.getUsername(), user.getPassword(), user.getGender(), mysqlDateString);
	}


	@Override
	public Integer deleteUser(Long userId) {
		String query = "delete from user where user_id = ?";
		return jdbcTemplate.update(query, userId);
	};
	
	


}
