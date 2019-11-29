package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.SeverityConfigDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.SeverityConfigDtoConverter;
import com.sgic.internal.defecttracker.defectservice.entities.SeverityConfig;
import com.sgic.internal.defecttracker.defectservice.services.SeverityConfigService;

@Service
public class SeverityConfigDtoMapper {
	
	@Autowired
	private SeverityConfigService severityConfigService;
	
	@SuppressWarnings("unused")
	@Autowired
	private SeverityConfigDtoConverter severityConfigDtoConverter;
	
	
	public SeverityConfig createSeverityConfig(SeverityConfigDto severityConfigDto) {
		SeverityConfig severityConfig = SeverityConfigDtoConverter.severityConfigDtoToSeverityConfig(severityConfigDto);
		return severityConfigService.saveSeverity(severityConfig);
	}
	
	
	public SeverityConfigDto getBySeverityConfigId(Long severityId) {
		SeverityConfig severityConfig = severityConfigService.getBySeverityId(severityId);
		return SeverityConfigDtoConverter.severityConfigToSeverityConfigDto(severityConfig);
	}
	
	public List<SeverityConfigDto> getAllSeverityConfig() {
		List<SeverityConfig> severityConfigList = severityConfigService.getAllSeverity();
		return SeverityConfigDtoConverter.severityConfigToSeverityConfigDtos(severityConfigList);
	}
	
	public SeverityConfig updateSeverityConfig(Long severityId, SeverityConfigDto severityConfigDto) {
		SeverityConfig severityConfig = SeverityConfigDtoConverter.severityConfigDtoToSeverityConfig(severityConfigDto);
		return severityConfigService.updateSeverity(severityConfig);

	}

	public void deleteSeverityConfigById(Long severityId) {
		severityConfigService.deleteSeverityById(severityId);
		
	}

}
