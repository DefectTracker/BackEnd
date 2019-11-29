package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.Module;
import com.sgic.internal.defecttracker.defectservice.repositories.ModuleRepository;
import com.sgic.internal.defecttracker.defectservice.services.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	//create modules
	@Override
	public Module createModule(Module module) {
		Module responseModule = moduleRepository.save(module);
		return responseModule;
	}

	//delete module by defect id
	@Override
	public void deleteById(String moduleId) {
		moduleRepository.deleteById(moduleId);

	}

	//get all modules by module id
	@Override
	public Module getByModuleId(String moduleId) {
		return moduleRepository.getByModuleId(moduleId);
	}


	//get all module detail
	@Override
	public List<Module> getallDetails() {
		return moduleRepository.findAll();
	}

	//update module details
	@Override
	public Module updateModule(String moduleId, Module module) {
		if (moduleRepository.findAll() != null) {
			module.setModuleId(moduleId);
			moduleRepository.save(module);
		}
		return module;
	}

	//check module is already is exists
	@Override
	public boolean isModuleAlreadyExists(String moduleId) {
		return moduleRepository.existsById(moduleId);
	}

	//get all modules by project id
	@Override
	public List<Module> getByprojectId(String projectid) {
		return moduleRepository.getByProjectId(projectid);
	}

	//get all modules by module name
	@Override
	public List<Module> getBymoduleName(String moduleName) {
		return moduleRepository.getBymoduleName(moduleName);
	}

}
