package com.legit.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.legit.config.ConnectionUtil;
import com.legit.model.User;

public class UserDao implements DaoContract<User, Integer> {

	public List<User> findAll() {
		List<User> users = new LinkedList<>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from app_user";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("passwd"))); //table column names
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int create(User t) {
		int result = -1;
		try(Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into app_user (username, passwd) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			result = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public User delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User findByUsername(String username) {
		User u = null;
		try(Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from app_user where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

}
