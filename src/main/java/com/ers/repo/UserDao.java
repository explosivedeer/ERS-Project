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
			String sql = "select * from ers_users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				users.add(new User(rs.getString("ers_username"), rs.getString("ers_password"), rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), rs.getInt("ers_users_id"), rs.getInt("user_role_id"))); //table column names
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public User findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public User delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User insert(User t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User verifyUser(String username, String password) {
		User user = null;
		Connection conn;
		int resultId = 0;
		try {
			conn = ConnectionUtil.getInstance().getConnection();
			String sqlCall = "{? = call login(?,?)}";
			CallableStatement cs = conn.prepareCall(sqlCall);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, username);
			cs.setString(3, password);
			
			cs.execute();
			
			resultId = cs.getInt(1);
			if (resultId == -1) {
				return user;
			}
			cs.close();
			
			String sqlState = "select * from ers_users";
			PreparedStatement ps = conn.prepareStatement(sqlState);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_first_name"), 
						rs.getString("user_last_name"),
						rs.getString("user_email"),
						rs.getInt("ers_users_id"),
						rs.getInt("user_role_id"));
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public int getRole(String username) {
		Connection conn;
		int resultRole = 0;
		try {
			conn = ConnectionUtil.getInstance().getConnection();
			String sql = "{? = call getRole(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, username);
			
			cs.execute();
			
			resultRole = cs.getInt(1);
			if (resultRole == -1) {
				return resultRole;
			}
			
			cs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultRole;
	}

}
