package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.StatusConfigDto;
import com.sgic.internal.defecttracker.defectservice.entities.Project;
import com.sgic.internal.defecttracker.defectservice.entities.StatusConfig;

@Service
public class StatusConfigDtoConverter {
	
	public static StatusConfigDto statConfigToStatusConfigDto(StatusConfig statusConfig) {
		StatusConfigDto statusConfigDto = new StatusConfigDto();

		if (statusConfig != null) {

			statusConfigDto.setStatusId(statusConfig.getStatusId());
			statusConfigDto.setProjectId(statusConfig.getProject().getProjectId());
			statusConfigDto.setStatusList(statusConfig.getStatusList());
			
			return statusConfigDto;
		}
		return null;
	}

	public static StatusConfig statusConfigDtoToStatusConfig(StatusConfigDto statusConfigDto) {
		StatusConfig statusConfig = new StatusConfig();

		statusConfig.setStatusId(statusConfigDto.getStatusId());
		Project obj=new Project();
		obj.setProjectId(statusConfigDto.getProjectId());
		statusConfig.setProject(obj);
		statusConfig.setStatusList(statusConfigDto.getStatusList());
		return statusConfig;
	}

	public static List<StatusConfigDto> statusConfigToStatusConfigDtos(List<StatusConfig> statusConfigList) {

		if (statusConfigList != null) {
			List<StatusConfigDto> lStatusConfigDto = new ArrayList<>();
			for (StatusConfig statusConfig : statusConfigList) {
				StatusConfigDto statusConfigDto = new StatusConfigDto();

				statusConfigDto.setStatusId(statusConfig.getStatusId());
				statusConfigDto.setProjectId(statusConfig.getProject().getProjectId());
				statusConfigDto.setStatusList(statusConfig.getStatusList());
				lStatusConfigDto.add(statusConfigDto);

			}

			return lStatusConfigDto;
		}
		return null;
	}


}
