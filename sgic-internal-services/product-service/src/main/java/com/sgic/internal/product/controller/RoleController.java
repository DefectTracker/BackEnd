package com.sgic.internal.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.product.entities.Role;
import com.sgic.internal.product.services.RoleServices;



@CrossOrigin
@RestController
public class RoleController {
	
	@Autowired
	private RoleServices roleServices;

	@PostMapping("/createRole")
	public Role saveRole(@RequestBody Role role) {
		return roleServices.createRole(role);	
	}
	
	@GetMapping("/getAllRoleInfo")
	public List<Role> getAllroleInfo(){
		return roleServices.getAllRoleInfo();	
	}
}
