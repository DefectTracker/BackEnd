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

import com.sgic.internal.defecttracker.defectservice.controller.dto.ResourceAllocationDto;
import com.sgic.internal.defecttracker.defectservice.entities.Employee;
import com.sgic.internal.defecttracker.defectservice.entities.Project;
import com.sgic.internal.defecttracker.defectservice.entities.ResourceAllocation;

@Service
public class ResourceAllocationConverter {
	

	@Autowired
	private static Logger logger = LogManager.getLogger(ResourceAllocationDto.class);

//	<----Convert Variable Entity To DTO --- For Send DTO In To DataBase ---->
	public static ResourceAllocationDto ResourceAllocationToResourceAllocationDto(
			ResourceAllocation resourceAllocation) {
		List<ResourceAllocationDto> resourceallocationlist = new ArrayList<ResourceAllocationDto>();
		ResourceAllocationDto resourceAllocationDto = new ResourceAllocationDto();
		if (resourceAllocation != null) {
			logger.info("Resource Allocation Converter--- successfully Converte Resource Allocation Entity To DTO");
			resourceAllocationDto.setResourceId(resourceAllocation.getResourceId());
			resourceAllocationDto.setProjectId(resourceAllocation.getProject().getProjectId());
			resourceAllocationDto.setProjectName(resourceAllocation.getProject().getProjectName());
			resourceAllocationDto.setEmpId(resourceAllocation.getEmpId());
			
//			Employee employee = new Employee();
//			employee.setEmployeeid(resourceAllocationDto.getEmployeeid());
//			employee.setName(resourceAllocationDto.getName());
//			employee.setFirstname(resourceAllocationDto.getFirstname());
//			employee.setEmail(resourceAllocationDto.getEmail());
//			employee.setAvailability(resourceAllocationDto.getAvailability());
//			employee.setBench(resourceAllocationDto.isBench());
//			employee.setDesignationid(resourceAllocationDto.getDesignationid());
//			employee.setDesignationname(resourceAllocationDto.getDesignationname());
			
			RestTemplate restTemplate = new RestTemplate();
			
			ResponseEntity<Employee> response = restTemplate.exchange(
                    //<--Get EMPLOYEE SERVICE EMPLOYEE LIST BY EMPLOYEE ID-->
					"http://localhost:8084/employeeservice/getempolyeebyid/" + resourceAllocation.getEmpId(),
					HttpMethod.GET, null, new ParameterizedTypeReference<Employee>() {
					});
			Employee employee = response.getBody();
			resourceAllocationDto.setEmployeeid(employee.getEmployeeid());
			resourceAllocationDto.setName(employee.getName());
			resourceAllocationDto.setFirstname(employee.getFirstname());
			resourceAllocationDto.setEmail(employee.getEmail());
			resourceAllocationDto.setAvailability(employee.getAvailability());
			resourceAllocationDto.setBench(employee.isBench());
			resourceAllocationDto.setDesignationid(employee.getDesignationid());
			resourceAllocationDto.setDesignationname(employee.getDesignationname());
			resourceallocationlist.add(resourceAllocationDto);

			return resourceAllocationDto;
		}
		return resourceAllocationDto;
	}
	

//	<----Convert Variable DTO To Entity  --- For Get  Data Form  DataBase  ---->
	public static ResourceAllocation ResourceAllocationDtoToResourceAllocation(
			ResourceAllocationDto resourceAllocationDto) {
		ResourceAllocation resourceAllocation = new ResourceAllocation();
		if (resourceAllocationDto != null) {
			logger.info("Resource Allocation Converter--- successfully Converte Resource Allocation DTO  To Entity");
			resourceAllocation.setResourceId(resourceAllocationDto.getResourceId());
			resourceAllocation.setEmpId(resourceAllocationDto.getEmpId());
			resourceAllocation.setAvailability(resourceAllocationDto.getAvailability());
//			<----Set Project Variable to Resource Allocation DTo---->
			Project project = new Project();
			project.setProjectId(resourceAllocationDto.getProjectId());
			project.setProjectName(resourceAllocationDto.getProjectName());
			resourceAllocation.setProject(project);
			
			return resourceAllocation;
		}

		return null;

	}

//	<----Convert Variable DTO To Entity  --- For Get  List  Form  DataBase  ---->
	public static List<ResourceAllocationDto> ResourceAllocationToResourceAllocationDtoList(
			List<ResourceAllocation> resourceAllocationList) {
		if (resourceAllocationList != null) {
			List<ResourceAllocationDto> ListresourceAllocationDto = new ArrayList<>();
			for (ResourceAllocation resourceAllocation : resourceAllocationList) {
				logger.info("Resource Allocation Converter--- successfully Converte List");
				ResourceAllocationDto resourceAllocationDto = new ResourceAllocationDto();
				resourceAllocationDto.setResourceId(resourceAllocation.getResourceId());
				resourceAllocationDto.setEmpId(resourceAllocation.getEmpId());
				logger.info("Employee Id" +resourceAllocation.getEmpId());
		//		System.out.print("Employeeid", +resourceAllocation.getEmpId());
				resourceAllocationDto.setProjectId(resourceAllocation.getProject().getProjectId());
				resourceAllocationDto.setProjectName(resourceAllocation.getProject().getProjectName());
				
				
				RestTemplate restTemplate = new RestTemplate();
				
				ResponseEntity<Employee> response = restTemplate.exchange(
	                    //<--Get EMPLOYEE SERVICE EMPLOYEE LIST BY EMPLOYEE ID-->
						"http://localhost:8084/employeeservice/getempolyeebyid/" + resourceAllocation.getEmpId(),
						HttpMethod.GET, null, new ParameterizedTypeReference<Employee>() {
						});
				Employee employee = response.getBody();
				resourceAllocationDto.setEmployeeid(employee.getEmployeeid());
				resourceAllocationDto.setName(employee.getName());
				resourceAllocationDto.setFirstname(employee.getFirstname());
				resourceAllocationDto.setEmail(employee.getEmail());
				resourceAllocationDto.setAvailability(employee.getAvailability());
				resourceAllocationDto.setBench(employee.isBench());
				resourceAllocationDto.setDesignationid(employee.getDesignationid());
				resourceAllocationDto.setDesignationname(employee.getDesignationname());
				
				ListresourceAllocationDto.add(resourceAllocationDto);

			}

			return ListresourceAllocationDto;
		}
		return null;

	}

//	<----Convert Variable DTO To Entity  --- For Send  List  Form  DataBase  ---->
	public static List<ResourceAllocation> ResourceAllocationDtoToResourceAllocationList(
			List<ResourceAllocationDto> resourceAllocationDtolist) {
		if (resourceAllocationDtolist != null) {
			List<ResourceAllocation> ListresourceAllocation = new ArrayList<>();
			for (ResourceAllocationDto resourceAllocationDto : resourceAllocationDtolist) {
				logger.info("Resource Allocation Converter--- successfully Converte Post List ");
				ResourceAllocation resourceAllocation = new ResourceAllocation();
				resourceAllocation.setResourceId(resourceAllocationDto.getResourceId());
				resourceAllocation.setEmpId(resourceAllocationDto.getEmpId());
//				<----Set Project Variable to Resource Allocation DTo---->
				Project project = new Project();
				project.setProjectId(resourceAllocationDto.getProjectId());
				resourceAllocation.setProject(project);
				ListresourceAllocation.add(resourceAllocation);

			}

			return ListresourceAllocation;
		}
		return null;

	}
}
