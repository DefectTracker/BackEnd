package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import com.sgic.internal.defecttracker.defectservice.entities.RoleAllocation;


public interface RoleAllocationService {
	
	public RoleAllocation createRoleAllocation (RoleAllocation  roleAllocation);
	
	
	public List <RoleAllocation> getAllRoleDetails();
	
	public RoleAllocation updateRoleAllocation(Long empId,RoleAllocation roleAllocation);
	
	public RoleAllocation getByroleId( Long roleId);


}
