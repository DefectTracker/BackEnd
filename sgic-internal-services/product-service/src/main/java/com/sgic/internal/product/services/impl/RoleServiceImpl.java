package com.sgic.internal.product.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.entities.Role;
import com.sgic.internal.product.repositories.RoleRepository;
import com.sgic.internal.product.services.RoleServices;

@Service
public class RoleServiceImpl implements RoleServices{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRoleInfo() {
		return roleRepository.findAll();
	}

}
