package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.TypeConfigDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.TypeConfigDtoConverter;
import com.sgic.internal.defecttracker.defectservice.entities.TypeConfig;
import com.sgic.internal.defecttracker.defectservice.services.TypeConfigService;

@Service
public class TypeConfigDtoMapper {
	
	@Autowired
	private TypeConfigService typeConfigService;
	
	@SuppressWarnings("unused")
	@Autowired
	private TypeConfigDtoConverter typeConfigDtoConverter;
	
	
	public TypeConfig createTypeConfig(TypeConfigDto typeConfigDto ) {
		TypeConfig typeConfig = TypeConfigDtoConverter.typeConfigDtoToTypeConfig(typeConfigDto);
		return typeConfigService.saveType(typeConfig);
	}
	
	
	public TypeConfigDto getBytypeConfigId(Long typeId) {
		TypeConfig typeConfig = typeConfigService.getByTypeId(typeId);
		return TypeConfigDtoConverter.typeConfigTotypeConfigDto(typeConfig);
	}
	
	public List<TypeConfigDto> getAlltypeConfig() {
		List<TypeConfig> typeConfigList = typeConfigService.getAllType();
		return TypeConfigDtoConverter.typeConfigToTypeConfigDtos(typeConfigList);
	}
	
	public TypeConfig updatetypeConfig(Long typeId, TypeConfigDto typeConfigDto) {
		TypeConfig typeConfig = TypeConfigDtoConverter.typeConfigDtoToTypeConfig(typeConfigDto);
		return typeConfigService.updateType(typeConfig);

	}

	public void deleteTypeConfigById(Long typeId) {
		typeConfigService.deleteTypeById(typeId);
		
	}


}
