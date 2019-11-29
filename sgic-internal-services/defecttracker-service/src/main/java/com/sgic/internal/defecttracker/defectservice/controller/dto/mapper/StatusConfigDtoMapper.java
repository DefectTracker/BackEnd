package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.StatusConfigDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.StatusConfigDtoConverter;
import com.sgic.internal.defecttracker.defectservice.entities.StatusConfig;
import com.sgic.internal.defecttracker.defectservice.services.StatusConfigService;

@Service
public class StatusConfigDtoMapper {
	
	@Autowired
	private StatusConfigService statusConfigService;
	
	@SuppressWarnings("unused")
	@Autowired
	private StatusConfigDtoConverter statusConfigDtoConverter ;
	
	
	public StatusConfig createStatusConfig(StatusConfigDto statusConfigDto) {
		StatusConfig statusConfig = StatusConfigDtoConverter.statusConfigDtoToStatusConfig(statusConfigDto);
		return statusConfigService.saveStatus(statusConfig);
	}
	
	
	public StatusConfigDto getByStatusConfigId(Long statusId) {
		StatusConfig statusConfig = statusConfigService.getByStatusId(statusId);
		return StatusConfigDtoConverter.statConfigToStatusConfigDto(statusConfig);
	}
	
	public List<StatusConfigDto> getAllStatusConfig() {
		List<StatusConfig> statusConfigList = statusConfigService.getAllStatus();
		return StatusConfigDtoConverter.statusConfigToStatusConfigDtos(statusConfigList);
	}
	
	public StatusConfig updateStatusConfig(Long statusId, StatusConfigDto statusConfigDto) {
		StatusConfig statusConfig = StatusConfigDtoConverter.statusConfigDtoToStatusConfig(statusConfigDto);
		return statusConfigService.updateStatus(statusConfig);

	}

	public void deleteStatusConfigById(Long statusId) {
		statusConfigService.deleteStatusById(statusId);
		
	}


}
