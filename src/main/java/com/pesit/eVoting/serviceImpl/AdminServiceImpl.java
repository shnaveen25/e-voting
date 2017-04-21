package com.pesit.eVoting.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.constants.Constants;

/**
 * The service class related to The admin
 * 
 * @author 
 */

import com.pesit.eVoting.service.AdminService;
import com.pesit.eVoting.sql.dao.AdminDAO;
import com.pesit.eVoting.sql.domain.Admin;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminRepository;

	@Override
	@Transactional
	public String loginAdmin(String email, String password) {
		 
		Admin existingAdmin = adminRepository.findByEmailAndPassword(email, password);
		
		if(existingAdmin != null) {
			return existingAdmin.getName();
		} else {
			return Constants.LOGIN_FAILED;
		}
	}
}
