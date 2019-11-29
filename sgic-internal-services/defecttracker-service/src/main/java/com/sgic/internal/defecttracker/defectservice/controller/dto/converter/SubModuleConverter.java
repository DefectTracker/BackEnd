package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;


import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.defectservice.controller.dto.SubModuleData;
import com.sgic.internal.defecttracker.defectservice.entities.Module;
import com.sgic.internal.defecttracker.defectservice.entities.Project;
import com.sgic.internal.defecttracker.defectservice.entities.SubModule;

public class SubModuleConverter {
	
	private SubModuleConverter() {
	}

	public static SubModuleData subModuleToSubModuleData(SubModule subModule) {
		SubModuleData subModuleData = new SubModuleData();

		if (subModule != null) {
			
			subModuleData.setSubModuleId(subModule.getSubModuleId());
			subModuleData.setSubModuleName(subModule.getSubModuleName());
			subModuleData.setModuleId(subModule.getModule().getModuleId());
			subModuleData.setProjectId(subModule.getModule().getProject().getProjectId());

			return subModuleData;
	}
		return null;
	}
	
		public static SubModule subModuleDataToSubModule(SubModuleData subModuleData) {
			SubModule subModule = new SubModule();
			
			// module constructor
			
			subModule.setSubModuleId(subModuleData.getSubModuleId());;
			subModule.setSubModuleName(subModuleData.getSubModuleName());
			
			Module module = new Module();
			module.setModuleId(subModuleData.getModuleId());
			subModule.setModule(module);
			
			Project project = new Project();
			project.setProjectId(subModuleData.getProjectId());
			module.setProject(project);
			
			return subModule;
		}
		
		public static List<SubModuleData>subModuleToSubModuleData(List<SubModule> subModuleList) {

			if (subModuleList != null) {
				List<SubModuleData> lSubModuleData = new ArrayList<>();
				for (SubModule submodule : subModuleList) {
					SubModuleData submoduleData = new SubModuleData();
					
					submoduleData.setSubModuleId(submodule.getSubModuleId());
					submoduleData.setSubModuleName(submodule.getSubModuleName());
//					submoduleData.setAbbre(submodule.getAbbre());
					
					
					submoduleData.setModuleId(submodule.getModule().getModuleId());
					submoduleData.setProjectId(submodule.getModule().getProject().getProjectId());
					lSubModuleData.add(submoduleData);
				}

				return lSubModuleData;
			}
			return null;

		}


	}

		

