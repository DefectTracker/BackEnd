package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.RoleAllocationConverter;
import com.sgic.internal.defecttracker.defectservice.controller.dto.RoleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.entities.RoleAllocation;
import com.sgic.internal.defecttracker.defectservice.services.RoleAllocationService;


@Service
public class RoleAllocationDtoMapper {
	
	
	@Autowired
	private RoleAllocationService  roleAllocationService;
	
	//DTO to Entity - Save role allocation
	public RoleAllocation saveRoleAllocationforMapper(RoleAllocationDto roleAllocationDto) {
		RoleAllocation roleAllocation = RoleAllocationConverter.roleAllocationDtoToRoleAllocation(roleAllocationDto);				
			return roleAllocationService.createRoleAllocation(roleAllocation);
		
	}
	
	//Entity to DTO - get role allocation
	public List<RoleAllocationDto>getllRoleAllocationForMapper(){
		List<RoleAllocation>roleAllocationList=roleAllocationService.getAllRoleDetails();
		return RoleAllocationConverter.roleAllocationToRoleAllocationDto(roleAllocationList);
		}
	
	//Entity to DTO - get role allocation by id
	public RoleAllocationDto getByroleId(Long roleId) {
		RoleAllocation roleAllocation= roleAllocationService.getByroleId(roleId);
		return RoleAllocationConverter.roleAllocationToRoleAllocationDto(roleAllocation);
		
	}
	
	//DTO to Entity - update role allocation
	public RoleAllocation UpdateRoleAllocation (Long empId,RoleAllocationDto roleAllocationDto ) {
		RoleAllocation roleAllocation = RoleAllocationConverter.roleAllocationDtoToRoleAllocation(roleAllocationDto);
	  return roleAllocationService.updateRoleAllocation(empId,roleAllocation);
	}
	
		}

