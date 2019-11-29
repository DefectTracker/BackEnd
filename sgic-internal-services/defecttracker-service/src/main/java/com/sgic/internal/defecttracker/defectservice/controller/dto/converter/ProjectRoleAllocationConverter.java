package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sgic.internal.defecttracker.defectservice.controller.dto.PasswordGeneratorText;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ProjectRoleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.entities.Employee;
import com.sgic.internal.defecttracker.defectservice.entities.Project;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;
import com.sgic.internal.defecttracker.defectservice.entities.ResourceAllocation;
import com.sgic.internal.defecttracker.defectservice.entities.Role;


@Service
public class ProjectRoleAllocationConverter {
	
//	@Autowired
//	private PasswordGeneratorText passwordGeneratorText;

	@Autowired
	private static Logger logger = LogManager.getLogger(ProjectRoleAllocationDto.class);

//	<----Convert Variable Entity To DTO --- For Send DTO In To DataBase ---->
	public static ProjectRoleAllocationDto ProjectRoleAllocationToProjectRoleAllocationDto(
			ProjectRoleAllocation projectRoleAllocation) {
		ProjectRoleAllocationDto projectRoleAllocationDto = new ProjectRoleAllocationDto();
		if (projectRoleAllocation != null) {
			logger.info("Project Role Allocation Converter--- successfully Converte Project Role Allocation Entity To DTO");
            projectRoleAllocationDto.setProjectroleId(projectRoleAllocation.getProjectroleId());
            projectRoleAllocationDto.setRoleId(projectRoleAllocation.getRoleAllocationList().getRoleId());
            projectRoleAllocationDto.setRoleName(projectRoleAllocation.getRoleAllocationList().getRoleName());
			projectRoleAllocationDto.setResourceId(projectRoleAllocation.getResourceAllocation().getResourceId());
            projectRoleAllocationDto.setProjectId(projectRoleAllocation.getResourceAllocation().getProject().getProjectId());
			projectRoleAllocationDto.setProjectName(projectRoleAllocation.getResourceAllocation().getProject().getProjectName());
//			projectRoleAllocationDto.setPassword("12456345");
            
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Employee> response = restTemplate.exchange(
					"http://localhost:8084/employeeservice/getempolyeebyid/"+projectRoleAllocation.getResourceAllocation().getEmpId(), HttpMethod.GET, null,
					new ParameterizedTypeReference<Employee>() {
					});
			Employee employee = response.getBody();
			System.out.println();
			projectRoleAllocationDto.setEmployeeid(employee.getEmployeeid());
			projectRoleAllocationDto.setName(employee.getName());
			projectRoleAllocationDto.setEmail(employee.getEmail());
			projectRoleAllocationDto.setFirstname(employee.getFirstname());
			
			
			return projectRoleAllocationDto;
		}
		return projectRoleAllocationDto;
	}
	
//	<----Convert Variable DTO To Entity  --- For Get  Data Form  DataBase  ---->
	public static ProjectRoleAllocation ProjectRoleAllocationDtoToProjectRoleAllocation(
			ProjectRoleAllocationDto projectRoleAllocationDto) {
		ProjectRoleAllocation projectRoleAllocation = new ProjectRoleAllocation();
		if (projectRoleAllocationDto != null) {
			logger.info("Project Role Allocation Converter--- successfully Converte Project Role Allocation DTO  To Entity");
			projectRoleAllocation.setProjectroleId(projectRoleAllocationDto.getProjectroleId());
			
			ResourceAllocation resourceAllocation = new ResourceAllocation();
			resourceAllocation.setResourceId(projectRoleAllocationDto.getResourceId());
			projectRoleAllocation.setResourceAllocation(resourceAllocation);
			
			Role role = new Role();
			role.setRoleId(projectRoleAllocationDto.getRoleId());
			projectRoleAllocation.setRoleAllocationList(role);
			
			
			
			
			return projectRoleAllocation;
		}

		return null;

	}
	
//	<----Convert Variable DTO To Entity  --- For Get  List  Form  DataBase  ---->
	public static List<ProjectRoleAllocationDto> ProjectRoleAllocationToProjectRoleAllocationDtoList(
			List<ProjectRoleAllocation> projectRoleAllocationList) {
		if (projectRoleAllocationList != null) {
			List<ProjectRoleAllocationDto> ListroleAllocationDto = new ArrayList<>();
			for (ProjectRoleAllocation projectRoleAllocation : projectRoleAllocationList) {
				logger.info("Project Role Allocation Converter--- successfully Converte List");
				ProjectRoleAllocationDto projectRoleAllocationDto = new ProjectRoleAllocationDto();
				projectRoleAllocationDto.setProjectroleId(projectRoleAllocation.getProjectroleId());
				projectRoleAllocationDto.setRoleId(projectRoleAllocation.getRoleAllocationList().getRoleId());
				projectRoleAllocationDto.setRoleName(projectRoleAllocation.getRoleAllocationList().getRoleName());
				projectRoleAllocationDto.setResourceId(projectRoleAllocation.getResourceAllocation().getResourceId());
				projectRoleAllocationDto.setProjectId(projectRoleAllocation.getResourceAllocation().getProject().getProjectId());
				projectRoleAllocationDto.setProjectName(projectRoleAllocation.getResourceAllocation().getProject().getProjectName());
				
				PasswordGeneratorText passwordGeneratorText = new PasswordGeneratorText();
				projectRoleAllocationDto.setPassword(passwordGeneratorText.generateRandomPassword());
				
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<Employee> response = restTemplate.exchange(
						"http://localhost:8084/employeeservice/getempolyeebyid/"+projectRoleAllocation.getResourceAllocation().getEmpId(), HttpMethod.GET, null,
						new ParameterizedTypeReference<Employee>() {
						});
				Employee employee = response.getBody();
				System.out.println();
				projectRoleAllocationDto.setEmployeeid(employee.getEmployeeid());
				projectRoleAllocationDto.setName(employee.getName());
				projectRoleAllocationDto.setEmail(employee.getEmail());
				projectRoleAllocationDto.setBench(employee.isBench());
				projectRoleAllocationDto.setFirstname(employee.getFirstname());
				ListroleAllocationDto.add(projectRoleAllocationDto);
				
				
//				RestTemplate restTemplate1 = new RestTemplate();
//				ResponseEntity<ResourceAllocation> response1 = restTemplate1.exchange(
//						"http://localhost:8081/defectservices/getprojectbyresource/"+projectRoleAllocation.getResourceAllocation().getProject().getProjectId(), HttpMethod.GET, null,
//						new ParameterizedTypeReference<ResourceAllocation>() {
//						});
//				ResourceAllocation resourceAllocation = response1.getBody();
//				System.out.println();
//				projectRoleAllocationDto.setResourceId(resourceAllocation.getResourceId());
//				System.out.println("resourceid" +resourceAllocation.getResourceId());
//				ListroleAllocationDto.add(projectRoleAllocationDto);

			}

			return ListroleAllocationDto;
		}
		return null;

	}
	
	
}
