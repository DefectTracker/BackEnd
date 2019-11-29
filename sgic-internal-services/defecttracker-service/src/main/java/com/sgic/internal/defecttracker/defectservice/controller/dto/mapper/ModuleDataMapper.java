package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.ModuleConverter;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ModuleData;
import com.sgic.internal.defecttracker.defectservice.entities.Module;
import com.sgic.internal.defecttracker.defectservice.services.ModuleService;

@Service
public class ModuleDataMapper {
	
	@Autowired
	public  ModuleService moduleService;
	
	
	public List<ModuleData>getAllModuleForMapper(String projectid){
		List<Module>moduleList =moduleService.getallModuleDetails(projectid);
		return ModuleConverter.moduleToModuleDataList(moduleList);
	}
	
	public Module saveModuleforMapper(ModuleData moduleData) {
		Module module = ModuleConverter.moduleDataToModule(moduleData);
		return moduleService.createModule(module);
	}
//	public List<ModuleData> getAllSubmoduleForMapper(String projectid){
//		List<Module>moduleList =moduleService.getSubmodule(projectid);
//		return ModuleConverter.moduleToModuleData(moduleList);
//	}
	public ModuleData getByModuleId(String moduleId) {
		Module module = moduleService.getByModuleId(moduleId);
		return ModuleConverter.moduleToModuleData(module);
		
	}
	
	public List<ModuleData> getBymoduleNameForMapper (String moduleName){
		List<Module> module = moduleService.getBymoduleName(moduleName);
		return ModuleConverter.moduleToModuleDataList(module);
	}
	
	public Module UpdateModule(String moduleId, ModuleData moduleData) {
		Module module = ModuleConverter.moduleDataToModule(moduleData);
		return moduleService.updateModule(moduleId, module);
	}
	
	public ModuleData deleteById(String moduleId) {
		moduleService.deleteById(moduleId);
		return null;
	}


	@SuppressWarnings("static-access")
	// List Method for ModuleMapper
	public List<ModuleData> getAllSortModuleInfo(String moduleId) {
		List<Module> sortModuleList = moduleService.findByModuleOrderByModuleIdDesc(moduleId);
		return ModuleConverter.moduleToModuleDataList(sortModuleList);

	}

}