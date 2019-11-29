package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.defectservice.controller.dto.RoleDto;
import com.sgic.internal.defecttracker.defectservice.entities.Role;

@Service
public class RoleConverter {
	
	@Autowired
	private static Logger logger = LogManager.getLogger(RoleDto.class);
	
//	<----Convert Variable DTO To Entity  --- For Get  List  Form  DataBase  ---->
	public static List<RoleDto> RoleToRoleDtoList(
			List<Role> roleList) {
		if (roleList != null) {
			List<RoleDto> ListroleDto = new ArrayList<>();
			for (Role role : roleList) {
				logger.info("Role Converter--- successfully Converte List");
				RoleDto roleDto = new RoleDto();
				roleDto.setRoleId(role.getRoleId());
				roleDto.setRoleName(role.getRoleName());
				ListroleDto.add(roleDto);

			}

			return ListroleDto;
		}
		return null;

	}

}
