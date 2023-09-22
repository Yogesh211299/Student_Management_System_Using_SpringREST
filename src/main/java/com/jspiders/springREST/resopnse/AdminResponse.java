package com.jspiders.springREST.resopnse;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.springREST.pojo.AdminPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminResponse {
private String msg;
private AdminPojo admin;
}
