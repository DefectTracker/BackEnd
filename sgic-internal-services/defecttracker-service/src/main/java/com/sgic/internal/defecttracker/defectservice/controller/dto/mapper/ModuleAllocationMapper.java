package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ModuleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.ModuleAllocationConverter;
import com.sgic.internal.defecttracker.defectservice.entities.ModuleAllocation;
import com.sgic.internal.defecttracker.defectservice.services.ModuleAllocationService;

@Service
public class ModuleAllocationMapper<ResultObject> {

	@Autowired
	private ModuleAllocationConverter moduleAllocationConverter;
	
	@Autowired
	private ModuleAllocationService moduleAllocationService;


	@SuppressWarnings({ "static-access", "unchecked" })
//	<--- Save Method's Mapped ---Single Object -->			
	public ModuleAllocation saveModuleAllocation(ModuleAllocationDto moduleAllocationDto) {
		return moduleAllocationService.createModuleAllocation(moduleAllocationConverter.ModuleAllocationDtoToModuleAllocation(moduleAllocationDto));
	}
	
	@SuppressWarnings("static-access")
	public Iterable<ModuleAllocationDto> getAllModuleAllocation() {
		Iterable<ModuleAllocation> moduleallocationList = moduleAllocationService.list();
		return moduleAllocationConverter.ModuleAllocationToModuleAllocationDtoList(moduleallocationList);
	}
	
//	<--- Module Deallocation  Method's Mapped  -->
	public void deleteResourceByresourceId(Long moduleAllocationMapper) {
//		logger.info("Resource Allaction Mapper --- Successfully Resource Deleted --- ");
		moduleAllocationService.deleteResourceById(moduleAllocationMapper);
	}
}
