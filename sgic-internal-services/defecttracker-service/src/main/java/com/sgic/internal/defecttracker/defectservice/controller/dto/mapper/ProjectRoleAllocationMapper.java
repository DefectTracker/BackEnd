package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ProjectRoleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.ProjectRoleAllocationConverter;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;
import com.sgic.internal.defecttracker.defectservice.services.ProjectRoleAllocationService;

@Service
public class ProjectRoleAllocationMapper {

	@Autowired
	private ProjectRoleAllocationConverter projectRoleAllocationConverter;

	@Autowired
	private ProjectRoleAllocationService projectRoleAllocationService;

	@Autowired
	private static Logger logger = LogManager.getLogger(ProjectRoleAllocationService.class);

	@SuppressWarnings("static-access")
//	<--- Save Method's Mapped ---Single Object -->
	public ProjectRoleAllocation saveRole(ProjectRoleAllocationDto projectRoleAllocationDto) {
		logger.info("Project Role Allaction Mapper --- Successfully Saved Project Role Allocation --- Single Object ");
		return projectRoleAllocationService.createroleAllocation(
				projectRoleAllocationConverter.ProjectRoleAllocationDtoToProjectRoleAllocation(projectRoleAllocationDto));
	}
	
	@SuppressWarnings("static-access")
//	<--- Get List Method's Mapped  -->
	public List<ProjectRoleAllocationDto> getAllRole() {
		logger.info("Project Role Allaction Mapper --- Successfully Listed Project Role Allocation --- ");
		List<ProjectRoleAllocation> roleList = projectRoleAllocationService.getAllRoleAllocation();
		return projectRoleAllocationConverter.ProjectRoleAllocationToProjectRoleAllocationDtoList(roleList);
	}

	@SuppressWarnings("static-access")
	public ProjectRoleAllocationDto getByprojectroleId(Long projectroleId) {
		ProjectRoleAllocation projectRoleAllocation = projectRoleAllocationService.getByprojectRoleId(projectroleId);
		return projectRoleAllocationConverter.ProjectRoleAllocationToProjectRoleAllocationDto(projectRoleAllocation);

	}

	// Delete Method for EmployeeMapper
	public void deleteByProjectId(Long projectroleId) {
		logger.info(" successfully deleted ");
		projectRoleAllocationService.deleteProjectByprojectId(projectroleId);
		

	}
	
//	<--- Get RoleByResourceId  -->
	@SuppressWarnings("static-access")
	public List<ProjectRoleAllocationDto> getRoleByProject(Long resourceId) {
		logger.info("Project Role Allaction Mapper --- Successfully Listed Project Role Allocation --- ");
		List<ProjectRoleAllocation> namelist = projectRoleAllocationService.getroleByProject(resourceId);
		return projectRoleAllocationConverter.ProjectRoleAllocationToProjectRoleAllocationDtoList(namelist);
	}
}
