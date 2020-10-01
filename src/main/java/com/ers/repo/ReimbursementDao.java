package com.ers.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import com.ers.config.ConnectionUtil;
import com.ers.model.Reimbursement;
import com.ers.model.User;


public class ReimbursementDao implements DaoContract<Reimbursement, Integer> {

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimb = new LinkedList<>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from ERS_REIMBURSEMENT";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimb.add(new Reimbursement(rs.getInt("reimb_id"),
											rs.getInt("reimb_amount"), 
											rs.getString("reimb_submitted"), 
											rs.getString("reimb_description"), 
											rs.getInt("reimb_author")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimb;
	}

	@Override
	public Reimbursement findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Reimbursement t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reimbursement delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Reimbursement insert(Reimbursement t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// EMPLOYEE METHODS
	
	public int createReimbursement(Reimbursement t) {
		Connection conn;
		int resultId = 0;
		try {
			conn = ConnectionUtil.getInstance().getConnection();
			String sql = "{? = call openReimb(?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, t.getAmount());
			cs.setString(3, t.getDescription());
			cs.setInt(4, t.getAuthor());
			cs.setInt(5, t.getTypeid());
			cs.setInt(6, t.getStatusid());
			
			cs.execute();
			
			resultId = cs.getInt(1);
			if (resultId == -1) {
				return -1;
			}
			cs.close();
			conn.close();
			
			t.setStatusid(resultId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultId;
	}

	
	public List<Reimbursement> findByUsername(String username) {
		List<Reimbursement> reimb = new LinkedList<Reimbursement>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement where ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reimb.add(new Reimbursement(rs.getInt("reimb_id"),
											rs.getInt("reimb_amount"),
											rs.getString("reimb_submitted"),
											rs.getString("reimb_description"),
											rs.getInt("reimb_author")));
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimb;
	}
	
	public List<Reimbursement> seePending() {
		List<Reimbursement> reimb = new LinkedList<Reimbursement>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement where reimb_status_id = '1'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reimb.add(new Reimbursement(rs.getInt("reimb_id"),
											rs.getInt("reimb_amount"),
											rs.getString("reimb_submitted"),
											rs.getString("reimb_description"),
											rs.getInt("reimb_author")));
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimb;
		
	}

	// MANAGER METHODS
	
	public void updateReimbursementStatus(int id, int status) {
		try(Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "update ers_reimbursement set reimb_status_id = ? where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, status);
			ps.executeUpdate();
			LocalDate resolved = LocalDate.now();
			sql = "update ers_reimbursement set reimb_resolved = '"+resolved+"' where reimb_id = "+id+";";
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
