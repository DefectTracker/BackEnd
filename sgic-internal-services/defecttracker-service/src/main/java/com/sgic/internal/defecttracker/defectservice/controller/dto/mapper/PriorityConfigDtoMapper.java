package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.PriorityConfigDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.PriorityConfigDtoConverter;
import com.sgic.internal.defecttracker.defectservice.entities.PriorityConfig;
import com.sgic.internal.defecttracker.defectservice.services.PriorityConfigService;

@Service
public class PriorityConfigDtoMapper {
	
	@Autowired
	private PriorityConfigService priorityConfigService;
	
	@SuppressWarnings("unused")
	@Autowired
	private PriorityConfigDtoConverter priorityConfigDtoConverter;
	
	
	public PriorityConfig createPriorityConfig(PriorityConfigDto priorityConfigDto) {
		PriorityConfig priorityConfig = PriorityConfigDtoConverter.priorityConfigDtoToPriorityConfig(priorityConfigDto);
		return priorityConfigService.savePriority(priorityConfig);
	}
	
	
	public PriorityConfigDto getByPriorityConfigId(Long priorityId) {
		PriorityConfig priorityConfig = priorityConfigService.getByPriorityId(priorityId);
		return PriorityConfigDtoConverter.priorityConfigToPriorityConfigDto(priorityConfig);
	}
	
	public List<PriorityConfigDto> getAllPriorityConfig() {
		List<PriorityConfig> priorityConfigList = priorityConfigService.getAllPriority();
		return PriorityConfigDtoConverter.priorityConfigToPriorityConfigDtos(priorityConfigList);
	}
	
	public PriorityConfig updatePriorityConfig(Long priorityId, PriorityConfigDto priorityConfigDto) {
		PriorityConfig priorityConfig = PriorityConfigDtoConverter.priorityConfigDtoToPriorityConfig(priorityConfigDto);
		return priorityConfigService.updatePriority(priorityConfig);

	}

	public void deletePriorityConfigById(Long priorityId) {
		priorityConfigService.deletePriorityById(priorityId);
		
	}

}
