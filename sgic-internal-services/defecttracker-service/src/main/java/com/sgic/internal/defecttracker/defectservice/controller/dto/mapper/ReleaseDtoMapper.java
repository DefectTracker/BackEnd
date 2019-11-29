package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.ReleaseDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.ReleaseDtoConverter;
import com.sgic.internal.defecttracker.defectservice.entities.Release;
import com.sgic.internal.defecttracker.defectservice.services.ReleaseService;

@Service
public class ReleaseDtoMapper {
	
	@Autowired
	private ReleaseDtoConverter releaseDtoConverter;
	
	@Autowired
	private ReleaseService releaseService;

	@SuppressWarnings("static-access")
	public List<ReleaseDto> getAllReleases() { // List Method for ReleaseMapper
		List<Release> releaseList = releaseService.getAllRelease();
		return releaseDtoConverter.releaseToReleaseDto(releaseList);

	}

	@SuppressWarnings("static-access")
	public Release saveRelease(ReleaseDto releaseDto) {
		return releaseService.createRelease(releaseDtoConverter.relaseDtoToRelease(releaseDto));
	}

}
