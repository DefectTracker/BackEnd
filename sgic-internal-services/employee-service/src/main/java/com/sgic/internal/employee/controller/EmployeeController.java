package com.sgic.internal.employee.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.sgic.internal.employee.dto.EmployeeDTO;
import com.sgic.internal.employee.dto.mapper.EmployeeDTOMapper;
import com.sgic.internal.employee.entities.Designation;
import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.services.EmployeeService;
import com.sgic.internal.employee.services.impl.NotificationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

	@Autowired
	private EmployeeDTOMapper employeeDTOMapper;

	@SuppressWarnings("unused")
	@Autowired
	private EmployeeService employeeservice;

	@Autowired
	private NotificationService notificationService;
	
	private static Logger logger = LogManager.getLogger(EmployeeDTOMapper.class);

	/* Author:KeerthanaR 17-06-2019 */
	// Create Employee
	@PostMapping(value = "/createemployee") 
	public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		logger.info("Employee Controller -> CreateEmployee");
		
		try {
			
//			String URL="http://localhost:8085/loginservice/api/auth/signup";
//			RestTemplate restTemplate = new RestTemplate();
//			HttpHeaders headers = new HttpHeaders();
//		    headers.setContentType(MediaType.APPLICATION_JSON);
//
//		    JSONObject jsonObject = new JSONObject();
//		    jsonObject .put("name","mathuu");
//		    jsonObject .put("username","mathuu");
//		    jsonObject .put("email","mathuu@gmail.com");
//		    jsonObject .put("role","developer");
//		    jsonObject .put("password","mathuu");
//		    
//		    System.out.println(jsonObject);
//
//		    HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject , headers);
//		    System.out.println(entity);
//		     restTemplate.postForObject(URL, entity, JSONObject.class);
			
			
			
			
			SimpleMailMessage mail = new SimpleMailMessage();
			Designation designation = new Designation();
			designation.setDesignationname(employeeDTO.getDesignationname());
			
//			Employee employee = new Employee();
//			employee.setEmail(employeeDTO.getEmail());
//			employee.setName(employeeDTO.getName());
//			employee.setFirstname(employeeDTO.getFirstname());
//			employee.setDesignation(designation);
			
			mail.setTo(employeeDTO.getEmail());
			mail.setSubject("Hello "+employeeDTO.getFirstname()+" this your password :"+employeeDTO.getName());
			mail.setText("This is a cool email notification");
			
			System.out.println("Employee Email Address:"+employeeDTO.getEmail());
			notificationService.sendNotofication(mail);
			if (employeeDTOMapper.getById(employeeDTO.getEmpId()) != null) {
				logger.info("Successfully Saved");
				System.out.println("Successfully Saved");
			} else {
				employeeDTOMapper.saveEmployee(employeeDTO);
			}

		} catch (Exception ex) {
			logger.error("Check Your Error");
			System.out.println("Something went Wrong" + ex.getMessage());
		}

		return null;
	}

	/* Author:KiishanthS 17-06-2019 */
	// List Employee
	@GetMapping(value = "/getallemployee") 
	public ResponseEntity<List<EmployeeDTO>> sortListEmployeeInfo(Long empId) {
		try {
			logger.info("Employee Controller : --> GetAllEmployeeInfo");
			return new ResponseEntity<>(employeeDTOMapper.getAllSortEmployeeInfo(empId), HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller Error :-> " + ex.getMessage());
		}

		return null;
	}

	/* Author:DalistaaA 17-06-2019 */
	// Get Employee By Employee ID
	@GetMapping("/getempolyeebyid/{empid}") 
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "empid") Long empid) {
		try {
			logger.info("Employee Controller :-> GetEmployeeById");
			return new ResponseEntity<>(employeeDTOMapper.getById(empid), HttpStatus.OK);

		} catch (Exception ex) {
			logger.error("Employee Controller :->" + ex.getMessage());

		}
		return null;

	}

	/* Author:JothiM 17-06-2019 */
	// Delete Employee Using Employee ID
	@DeleteMapping("/deletebyid/{empId}") 
	public ResponseEntity<String> deleteEmployeeByempId(@PathVariable("empId") Long empId) {
		try {
			logger.info("Employee Controller :-> DeleteEmployeeById");
			employeeDTOMapper.deleteByEmployeeId(empId);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller :-> Error" + ex.getMessage());
		}
		return null;
	}

	/* Author:ThuvarakanT 17-06-2019 */
	// Get Employee By Email
	@GetMapping("/getemail/{email}")
	public ResponseEntity<EmployeeDTO> getEmployeeByEmail(@PathVariable(name = "email") String email) {
		try {
			logger.info("Employee Controller:: -> GetEmail");
			return new ResponseEntity<>(employeeDTOMapper.getByEmployeeEmailforMapper(email), HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller:: -> Error" + ex.getMessage());
		}
		return null;
	}

	/* Author:RammiyaN 19-06-2019 */
	// update Employee Using Employee ID
	@PutMapping("update/{empId}") 
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		try {
			logger.info("Employee Controller :-> Update");
			if (employeeDTOMapper.UpdateEmployee(employeeDTO) != null) {
				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
			}
			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller :-> Error" + ex.getMessage());
		}

		return null;
	}

	/* Author:DalistaaA 19-06-2019 */
	// Get Employee By Designation
	@GetMapping("/getdesignation/{designationid}") 
	public List<EmployeeDTO> getByDesignation(@PathVariable(name = "designationid") Long designationid) {
		try {
			logger.info("Employee Controller :-> GetDesignation");
			return employeeDTOMapper.getEmployeeByDesignation(designationid);
		} catch (Exception ex) {
			logger.error("Employee Controller :-> Error" + ex.getMessage());
		}
		return null;

	}

	/* Author:KeerthanaR 23-06-2019 */
	// Get Employee By Name
	@GetMapping("/getname/{name}") 
	public List<EmployeeDTO> getByName(@PathVariable(name = "name") String name) {
		try {
			logger.info("Employee Controller -> GetName");
			return employeeDTOMapper.getEmployeeByName(name);
		} catch (Exception ex) {
			logger.error("Employee Controller -> error" + ex.getMessage());
		}
		return null;

	}

	@GetMapping("/getcount")
// <----	Employee DataBase Employee Table Row Count Method --->
	public ResponseEntity<Long> getTotalCount() {
		try {
			logger.info("Employee Controller :-> getCount");
			return new ResponseEntity<>(employeeDTOMapper.getByEmployeeCountforMapper(), HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller :-> Error" + ex.getMessage());
		}
		return null;

	}

	@PostMapping("/database")
//	<----Import Excel File For Employee Service Employee Table---> 
	public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
		try {
			System.out.println("controller");
			employeeservice.store(file);
			model.addAttribute("message", "File uploaded successfully!");
		} catch (Exception e) {
			model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
		}
		return "File uploaded successfully";
	}


}
