package com.sgic.internal.product.services;

import java.util.List;

import com.sgic.internal.product.entities.Role;



public interface RoleServices {

	public Role createRole(Role role);
	
	List<Role> getAllRoleInfo();
}
