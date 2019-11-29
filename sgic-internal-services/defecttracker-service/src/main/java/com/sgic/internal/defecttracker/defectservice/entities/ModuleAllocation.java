package com.sgic.internal.defecttracker.defectservice.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "module_allocation")
public class ModuleAllocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long moduleallocationId;
	
	@ManyToOne
	@JoinColumn(name = "projectroleId",nullable = false)
	private ProjectRoleAllocation projectRoleAllocation;
	
	@ManyToOne
	@JoinColumn(name = "subModuleId")
	@Embedded
	private SubModule subModule;

	public Long getModuleallocationId() {
		return moduleallocationId;
	}

	public void setModuleallocationId(Long moduleallocationId) {
		this.moduleallocationId = moduleallocationId;
	}

	public ProjectRoleAllocation getProjectRoleAllocation() {
		return projectRoleAllocation;
	}

	public void setProjectRoleAllocation(ProjectRoleAllocation projectRoleAllocation) {
		this.projectRoleAllocation = projectRoleAllocation;
	}

	public SubModule getSubModule() {
		return subModule;
	}

	public void setSubModule(SubModule subModule) {
		this.subModule = subModule;
	}
}
