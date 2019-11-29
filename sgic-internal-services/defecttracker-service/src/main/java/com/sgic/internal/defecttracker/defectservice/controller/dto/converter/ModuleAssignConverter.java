package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;

import com.sgic.internal.defecttracker.defectservice.controller.dto.ModuleAssignDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ProjectDto;
import com.sgic.internal.defecttracker.defectservice.entities.Module;
import com.sgic.internal.defecttracker.defectservice.entities.ModuleAssign;
import com.sgic.internal.defecttracker.defectservice.entities.Project;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;

public class ModuleAssignConverter {
	private ModuleAssignConverter() {
	}

	public static ModuleAssign moduleAssignDtoToModuleAssign(ModuleAssignDto moduleAssignDto) {
		ModuleAssign moduleAssign = new ModuleAssign();

		if (moduleAssignDto != null) {

			moduleAssign.setProjectId(moduleAssignDto.getProjectId());
			moduleAssign.setSubmoduleId(moduleAssignDto.getSubModuleId());

			Module module = new Module();
			module.setModuleId(moduleAssignDto.getModuleId());
			moduleAssign.setModule(module);
			
			ProjectRoleAllocation projectRoleAllocation = new ProjectRoleAllocation();
			projectRoleAllocation.setProjectroleId(moduleAssignDto.getProjectId());
			moduleAssign.setProjectRoleAllocation(projectRoleAllocation);
			

			return moduleAssign;
		}
		return null;
	}

}
