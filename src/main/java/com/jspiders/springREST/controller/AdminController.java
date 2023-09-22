package com.jspiders.springREST.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springREST.pojo.AdminPojo;
import com.jspiders.springREST.resopnse.AdminResponse;
import com.jspiders.springREST.service.AdminService;

@RestController
public class AdminController {
	@Autowired
private AdminService service;

    @PostMapping(path = "/createAccount",
    		     consumes =  MediaType.APPLICATION_JSON_VALUE,
    		     produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<AdminResponse> createAdmin(@RequestBody AdminPojo pojo){
	   AdminPojo admin=service.createAdmin(pojo);
	   if (admin != null) {
		return new ResponseEntity<AdminResponse>(new AdminResponse("account created successfully..!",admin),HttpStatus.ACCEPTED);
	}
	   return new ResponseEntity<AdminResponse>(new AdminResponse("account not created",null),HttpStatus.NOT_ACCEPTABLE);
}
    
    @PostMapping(path = "/login",
    		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		     produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminResponse> loginAdmin(@RequestBody AdminPojo pojo){
    	AdminPojo admin=service.loginAdmin(pojo);
    	if (admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Login Successfully..!",admin),HttpStatus.OK);
		}
    	return new ResponseEntity<AdminResponse>(new AdminResponse("invalid username & password..!",null),HttpStatus.NOT_FOUND);
    }
    
    
}
