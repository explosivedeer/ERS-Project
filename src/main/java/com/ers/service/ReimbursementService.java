package com.ers.service;

import java.util.List;

import com.ers.model.Reimbursement;
import com.ers.repo.ReimbursementDao;

public class ReimbursementService {

	private ReimbursementDao rd;
	
	public ReimbursementService() {
		rd = new ReimbursementDao();
	}
	
	public List<Reimbursement> findAll() {
		return rd.findAll();
	}

}
