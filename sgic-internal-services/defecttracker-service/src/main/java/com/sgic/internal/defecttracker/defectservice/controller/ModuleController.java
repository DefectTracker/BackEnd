package com.sgic.internal.defecttracker.defectservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ModuleData;
import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.ModuleDataMapper;
import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.ProjectDtoMapper;
import com.sgic.internal.defecttracker.defectservice.entities.Module;
import com.sgic.internal.defecttracker.defectservice.entities.Project;
import com.sgic.internal.defecttracker.defectservice.repositories.ModuleRepository;
import com.sgic.internal.defecttracker.defectservice.services.ModuleService;
import com.sgic.internal.defecttracker.defectservice.services.ProjectService;

@CrossOrigin
@RestController
public class ModuleController {
	private static Logger logger = LogManager.getLogger(ModuleRepository.class);

	@Autowired
	public ModuleDataMapper moduleDataMapper;

	@Autowired
	public ProjectDtoMapper projectDtoMapper;

	@Autowired
	public ProjectService projectService;

	@Autowired
	public ModuleRepository moduleRepository;

	@Autowired
	public ModuleService moduleService;

	@PostMapping(value = "/createmodule")
	public ResponseEntity<Object> createModule(@Valid @RequestBody ModuleData moduleData) {
		moduleDataMapper.saveModuleforMapper(moduleData);
		return new ResponseEntity<Object>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);

	}

	// Get Mapping For Get All Module
	@GetMapping(value = "/GetAllmodule")
	public ResponseEntity<List<ModuleData>> listModuleInfo(String projectid) {
		logger.info("Module are listed ");
		return new ResponseEntity<>(moduleDataMapper.getAllModuleForMapper(projectid), HttpStatus.OK);
	}
	// Get All By Project Id  //
	@GetMapping(value = "/GetAllmodule/{projectid}")
	public List<Module> getModuleByProjectId(@PathVariable String projectid) {
		logger.info("Module are listed ");
		return moduleService.getByprojectId(projectid);
	}
	// Get All Details in module Table
	@GetMapping("/FindallMain")
	public List<Module> FindallMain(Module module,String moduleId) {
		List<Module> submodule  = (List<Module>) moduleService.getallDetails(moduleId);
		return submodule;
	}
	
	@GetMapping("/findallmoduleinfo/{moduleId}")
	public Module allmoduleInfo(@PathVariable String moduleId) {
		Module submodule  = moduleService.getByallModuleId(moduleId);
		return submodule;
	}
	
	@PutMapping("/updatemodule/{moduleId}")
	public ResponseEntity<String> updatemodules(@RequestBody Module module){
		moduleService.moduleUpdate(module);
		return null;
	}
	
	
//	@GetMapping("/findProject")
//	public  List<Project> findallmain(Project project) {
//		 List<Project> moduless = (List<Project>) projectservice.findAll();
//		 return moduless;
//	        	
//	}
//	@GetMapping(value = "/GetAllmodulesubmodule/{projectid}")
//	public ResponseEntity<List<Object>> getModuleBySubModuleId(@PathVariable String projectid) {
//		logger.info("Module are listed ");
//		return new ResponseEntity<>(moduleService.getSubmodule(projectid), HttpStatus.OK);
//	}

	// Get Mapping For Get Module By Id
	@GetMapping("/GetmoduleById/{moduleId}")
	public ResponseEntity<ModuleData> getModuleById(@PathVariable String moduleId) {
		logger.info("Module are get by id ");
		return new ResponseEntity<>(moduleDataMapper.getByModuleId(moduleId), HttpStatus.OK);
	}

	// Get Mapping For Module Name
	@GetMapping("/getModuleName/{moduleName}")
	public List<ModuleData> getBymoduleName(@PathVariable String moduleName) {
		logger.info("Module are get by name ");
		return moduleDataMapper.getBymoduleNameForMapper(moduleName);
	}

	// Delete Mapping For Module
	@DeleteMapping("deleteModuleById/{moduleId}")
	public void deleteById(@PathVariable String moduleId) {
		logger.info("Module are delete by id ");
		moduleDataMapper.deleteById(moduleId);
		
	}

	// Put Mapping For Module
	@PutMapping("/updateModule/{moduleId}")
	public ResponseEntity<String> updateModule(@Valid @PathVariable(name = "moduleId") String moduleId,
			@RequestBody ModuleData moduleData) {
		logger.info("Modulecontroller -> updatedModule");
		if (moduleDataMapper.UpdateModule(moduleId, moduleData) != null)
			;
		{
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}
	}

	// Abbrivation for module
	@PutMapping("/module/project/{projectId}")
	public Module createNewModule(@PathVariable(name = "projectId") String projectId,
			@RequestBody ModuleData moduleData) {
		Project project = projectService.getByprojectId(projectId);
		List<Module> modules = moduleRepository.findModuleByProject(project);
		int a = modules.size();
		String moduleSerial = project.getProjectId() + "-" + moduleData.getModuleId() + "-" + a;

		Module module = new Module();
		module.setModuleId(moduleSerial);
		module.setModuleName(moduleData.getModuleName());
		module.setProject(project);

		return moduleRepository.save(module);

	}
	
	@GetMapping(value = "/getallmodule")
	public ResponseEntity<List<ModuleData>> sortListModuleInfo(String moduleId) {
		try {
			return new ResponseEntity<>(moduleDataMapper.getAllSortModuleInfo(moduleId), HttpStatus.OK);
		} catch (Exception ex) {
		}

		return null;
	}
}
