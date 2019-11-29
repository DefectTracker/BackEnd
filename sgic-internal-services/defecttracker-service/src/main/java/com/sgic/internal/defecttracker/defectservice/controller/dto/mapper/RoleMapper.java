package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.RoleDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.RoleConverter;
import com.sgic.internal.defecttracker.defectservice.entities.Role;
import com.sgic.internal.defecttracker.defectservice.services.RoleService;

@Service
public class RoleMapper {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Autowired
	private static Logger logger = LogManager.getLogger(RoleService.class);
	
	@SuppressWarnings("static-access")
//	<--- Get List Method's Mapped  -->
	public List<RoleDto> getAllRole() {
		logger.info("Role Mapper --- Successfully Listed Role --- ");
		List<Role> roleList = roleService.getAllRole();
		return roleConverter.RoleToRoleDtoList(roleList);
	}
}
