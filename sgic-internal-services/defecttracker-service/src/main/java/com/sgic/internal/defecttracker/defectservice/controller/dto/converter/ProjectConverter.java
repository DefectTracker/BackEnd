package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import com.sgic.internal.defecttracker.defectservice.controller.dto.ProjectDto;
import com.sgic.internal.defecttracker.defectservice.entities.Project;



public class ProjectConverter {

	private ProjectConverter() {
	}

	public static ProjectDto projectToProjectDto(Project project) {
		ProjectDto projectDto = new ProjectDto();

		if (project != null) {

			projectDto.setProjectId(project.getProjectId());
			projectDto.setProjectName(project.getProjectName());
			projectDto.setProjectAbbr(project.getProjectAbbr());
			projectDto.setType(project.getType());
			projectDto.setStartDate(project.getStartDate());
			projectDto.setEndDate(project.getEndDate());
			projectDto.setDuration(project.getDuration());
			projectDto.setStatus(project.getStatus());

			return projectDto;
		}
		return null;
	}

	public static Project projectDtoToProject(ProjectDto projectDto) {
		Project project = new Project();


		project.setProjectId(projectDto.getProjectId());
		project.setProjectName(projectDto.getProjectName());
		project.setProjectAbbr(projectDto.getProjectAbbr());
		project.setType(projectDto.getType());
		project.setStartDate(projectDto.getStartDate());
		project.setEndDate(projectDto.getEndDate());
		project.setDuration(projectDto.getDuration());
		project.setStatus(projectDto.getStatus());
	

		return project;
	}

	public static List<ProjectDto> projectToProjectDto(List<Project> projectList) {

		if (projectList != null) {
			List<ProjectDto> lProjectDto = new ArrayList<>();
			for (Project project : projectList) {
				ProjectDto projectDto = new ProjectDto();


				projectDto.setProjectId(project.getProjectId());
				projectDto.setProjectName(project.getProjectName());
				projectDto.setProjectAbbr(project.getProjectAbbr());
				projectDto.setType(project.getType());
				projectDto.setStartDate(project.getStartDate());
				projectDto.setEndDate(project.getEndDate());
				projectDto.setDuration(project.getDuration());
				projectDto.setStatus(project.getStatus());
				lProjectDto.add(projectDto);

			}

			return lProjectDto;
		}
		return null;

	}

}
