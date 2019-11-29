package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.defectservice.controller.dto.ModuleData;
import com.sgic.internal.defecttracker.defectservice.entities.Module;
import com.sgic.internal.defecttracker.defectservice.entities.Project;
import com.sgic.internal.defecttracker.defectservice.entities.SubModule;

public class ModuleConverter {
	
	public static ModuleData moduleToModuleData(Module module) {
		ModuleData moduleData = new ModuleData();

		if (module != null) {
			moduleData.setModuleId(module.getModuleId());
			moduleData.setModuleName(module.getModuleName());

			new Module();
			moduleData.setProjectid(module.getProject().getProjectId());
			return moduleData;
		}
		return null;
	}
	
	public static Module moduleDataToModule(ModuleData moduleData) {
		Module module = new Module();  
		// project constructor
		Project project = new Project();
		
		new SubModule();
		
		module.setModuleId(moduleData.getModuleId());
		module.setModuleName(moduleData.getModuleName());
		
		// get by project id
		project.setProjectId(moduleData.getProjectid());
		module.setProject(project);
		
		return module;
	}
	
	public static List<ModuleData> moduleToModuleData(List<Module> moduleList) {

		if (moduleList != null) {
			List<ModuleData> lModuleData = new ArrayList<>();
			for (Module module : moduleList) {
				ModuleData moduleData = new ModuleData();
				
				moduleData.setModuleId(module.getModuleId());
				moduleData.setModuleName(module.getModuleName());
				lModuleData.add(moduleData);
			}

			return lModuleData;
		}
		return null;

	}

}
