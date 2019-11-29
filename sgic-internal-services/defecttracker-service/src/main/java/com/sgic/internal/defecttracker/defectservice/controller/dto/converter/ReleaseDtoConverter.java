package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.ReleaseDto;
import com.sgic.internal.defecttracker.defectservice.entities.Release;

@Service
public class ReleaseDtoConverter {
	
	//Create release
	public static Release relaseDtoToRelease(ReleaseDto releaseDto) {
		Release release = new Release();
		
		release.setReleaseId(releaseDto.getReleaseId());
		release.setReleaseName(releaseDto.getReleaseName());
		
		return release;
	}

	//getAllRelease
	public static List<ReleaseDto> releaseToReleaseDto(List<Release> releaseList) {

		if (releaseList != null) {
			List<ReleaseDto> releaseDto1 = new ArrayList<>();
			for (Release release : releaseList) {
				ReleaseDto releaseDto = new ReleaseDto();
				
				releaseDto.setReleaseId(release.getReleaseId());
				releaseDto.setReleaseName(release.getReleaseName());
				
				releaseDto1.add(releaseDto);
			}
			return releaseDto1;
		}
		return null;

	}


}
