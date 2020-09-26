package com.ers.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import com.ers.config.ConnectionUtil;
import com.ers.model.User;

public class UserDao implements DaoContract<User, Integer> {
	
	@Override
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
	
	// LOGIN METHOD:
	@Override
	public boolean verifyUser(User t) {
		Connection conn;
		int resultId = 0;
		try {
			conn = ConnectionUtil.getInstance().getConnection();
			String sql = "{? = call login(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, t.getUsername());
			cs.setString(3, t.getPassword());
			
			cs.execute();
			
			resultId = cs.getInt(1);
			if (resultId == -1) {
				return false;
			}
			t.setId(resultId);
			cs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public User findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
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
	
	@Override
	public User delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
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
