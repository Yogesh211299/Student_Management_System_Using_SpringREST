package com.jspiders.springREST.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AdminPojo {

	@Id
	private String username;
	private String password;
}
