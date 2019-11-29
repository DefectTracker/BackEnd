package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.TypeConfigDto;
import com.sgic.internal.defecttracker.defectservice.entities.Project;
import com.sgic.internal.defecttracker.defectservice.entities.TypeConfig;

@Service
public class TypeConfigDtoConverter {
	
	public static TypeConfigDto typeConfigTotypeConfigDto(TypeConfig typeConfig) {
		TypeConfigDto typeConfigDto = new TypeConfigDto();

		if (typeConfig != null) {

		typeConfigDto.setTypeId(typeConfig.getTypeId());
		typeConfigDto.setProjectId(typeConfig.getProject().getProjectId());
		typeConfigDto.setTypeList(typeConfig.getTypeList());

			return typeConfigDto;
		}
		return null;
	}

	public static TypeConfig typeConfigDtoToTypeConfig(TypeConfigDto typeConfigDto) {
		TypeConfig typeConfig = new TypeConfig();

		typeConfig.setTypeId(typeConfigDto.getTypeId());
		Project obj=new Project();
		obj.setProjectId(typeConfigDto.getProjectId());
		typeConfig.setProject(obj);
		typeConfig.setTypeList(typeConfigDto.getTypeList());
	
		return typeConfig;
	}

	public static List<TypeConfigDto> typeConfigToTypeConfigDtos(List<TypeConfig> typeConfigList) {

		if (typeConfigList != null) {
			List<TypeConfigDto> lTypeConfigDto = new ArrayList<>();
			for (TypeConfig typeConfig : typeConfigList) {
				TypeConfigDto typeConfigDto = new TypeConfigDto();

				typeConfigDto.setTypeId(typeConfig.getTypeId());
				typeConfigDto.setProjectId(typeConfig.getProject().getProjectId());
				typeConfigDto.setTypeList(typeConfig.getTypeList());
				lTypeConfigDto.add(typeConfigDto);

			}

			return lTypeConfigDto;
		}
		return null;
	}

}
