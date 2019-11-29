package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.DefectConfigDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.DefectConfigConverter;
import com.sgic.internal.defecttracker.defectservice.entities.DefectConfig;
import com.sgic.internal.defecttracker.defectservice.services.DefectConfigService;

@Service
public class DefectConfigMapper {
	@Autowired
	private DefectConfigService defectConfigService;
	
	@Autowired
	private DefectConfigConverter defectConfigConverter;
	
	// Mapper for creating defect config
	public boolean createDefectConfig(DefectConfigDto defectConfigDto) {
		DefectConfig defectConfig = defectConfigConverter.defectConfigDtoToDefectConfig(defectConfigDto);
		defectConfigService.createDefectConfig(defectConfig);
		return true;
	}
	
	public DefectConfigDto getDefectConfigById(Long id) {		
	    DefectConfig defectConfigList = defectConfigService.findDefectConfigById(id);
	    if (defectConfigList != null) {
	    	return defectConfigConverter.defectConfigToDefectConfigDto(defectConfigList);
	    }
	    else {
	    	return null;
	    }	    
	}

}
