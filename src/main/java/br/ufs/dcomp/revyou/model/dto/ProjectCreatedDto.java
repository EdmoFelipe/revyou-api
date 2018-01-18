package br.ufs.dcomp.revyou.model.dto;

import br.ufs.dcomp.revyou.model.entity.Project;

public class ProjectCreatedDto {

	private String dsKey;
	private String dsTitle;
	private String dsProject;
	private Integer tpReview;
	private Long idProject;

	public ProjectCreatedDto() {
		super();
	}

	public ProjectCreatedDto(Project project) {
		super();
		this.dsKey = project.getDsKey();
		this.dsTitle = project.getDsTitle();
		this.dsProject = project.getDsProject();
		this.tpReview = project.getTpReview().getCode();
		this.idProject = project.getIdProject();
	}

	public Long getIdProject() {
		return idProject;
	}

	public void setIdProject(Long idProject) {
		this.idProject = idProject;
	}

	public String getDsKey() {
		return dsKey;
	}

	public void setDsKey(String dsKey) {
		this.dsKey = dsKey;
	}

	public String getDsTitle() {
		return dsTitle;
	}

	public void setDsTitle(String dsTitle) {
		this.dsTitle = dsTitle;
	}

	public String getDsProject() {
		return dsProject;
	}

	public void setDsProject(String dsProject) {
		this.dsProject = dsProject;
	}

	public Integer getTpReview() {
		return tpReview;
	}

	public void setTpReview(Integer tpReview) {
		this.tpReview = tpReview;
	}
}