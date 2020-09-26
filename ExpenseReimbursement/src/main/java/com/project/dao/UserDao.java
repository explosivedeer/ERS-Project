package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project.config.ConnectionUtil;
import com.project.model.User;

public class UserDao implements DaoContract <User, Integer>{

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User insert(User t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User findByUsername(String username ) {
		User u = null;
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			String sql = "select * from boot_user where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return u;
	}

}
