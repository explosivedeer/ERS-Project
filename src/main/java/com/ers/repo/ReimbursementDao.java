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
import com.ers.model.Reimbursement;


public class ReimbursementDao implements DaoContract<Reimbursement, Integer> {

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimb = new LinkedList<>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from ERS_REIMBURSEMENT where REIMB_AUTHOR = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimb.add(new Reimbursement(rs.getInt("reimb_amount"), 
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
	public boolean verifyUser(Reimbursement t) {
		// TODO Auto-generated method stub
		return false;
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
	public int create(Reimbursement t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reimbursement delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
