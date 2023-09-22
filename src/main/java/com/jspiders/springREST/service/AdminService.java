
package com.jspiders.springREST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springREST.pojo.AdminPojo;
import com.jspiders.springREST.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
private AdminRepository repository;

	public AdminPojo createAdmin(AdminPojo pojo) {    
		AdminPojo admin=repository.createAdmin(pojo);
		return admin;
	}

	public AdminPojo loginAdmin(AdminPojo pojo) {
    AdminPojo admin=repository.loginAdmin(pojo);
		return admin;
	}

}
