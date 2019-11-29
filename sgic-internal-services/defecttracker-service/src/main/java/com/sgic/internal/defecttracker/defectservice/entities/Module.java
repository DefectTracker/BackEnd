package com.sgic.internal.defecttracker.defectservice.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Embeddable
@Entity
@Table(schema = "defectservices", name = "module")
public class Module {
	@Id
	private String moduleId;
	private String moduleName;

	  @OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "module")
	    private ModuleAssign moduleAssign;

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	// create relationship with project //
	@ManyToOne
	@JoinColumn(name = "projectid", nullable = false)
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	// create relationship with SubModule //
	@OneToMany(mappedBy = "module", cascade = { CascadeType.ALL })
	public List<SubModule> subModule;

	public List<SubModule> getSubModule() {
		return subModule;
	}

	public void setSubModule(List<SubModule> subModule) {
		this.subModule = subModule;
	}
}
