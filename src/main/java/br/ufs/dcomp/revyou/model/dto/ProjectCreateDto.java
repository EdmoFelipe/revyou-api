package br.ufs.dcomp.revyou.model.dto;

import br.ufs.dcomp.revyou.model.entity.Country;

public class ProjectCreateDto {

	private String dsKey;
	private String dsTitle;
	private String dsProject;
	private Integer tpReview;
	private String dsSsoResearcher;

	// part create Institution
	private Country country;
	private String nmInstitution;
	private String dsAbbreviation;

	public ProjectCreateDto() {
		super();
	}

	public ProjectCreateDto(String dsKey, String dsTitle, String dsProject, Integer tpReview, String dsSsoResearcher,
			Country country, String nmInstitution, String dsAbbreviation) {
		super();
		this.dsKey = dsKey;
		this.dsTitle = dsTitle;
		this.dsProject = dsProject;
		this.tpReview = tpReview;
		this.dsSsoResearcher = dsSsoResearcher;
		this.country = country;
		this.nmInstitution = nmInstitution;
		this.dsAbbreviation = dsAbbreviation;
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

	public String getDsSsoResearcher() {
		return dsSsoResearcher;
	}

	public void setDsSsoResearcher(String dsSsoResearcher) {
		this.dsSsoResearcher = dsSsoResearcher;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getNmInstitution() {
		return nmInstitution;
	}

	public void setNmInstitution(String nmInstitution) {
		this.nmInstitution = nmInstitution;
	}

	public String getDsAbbreviation() {
		return dsAbbreviation;
	}

	public void setDsAbbreviation(String dsAbbreviation) {
		this.dsAbbreviation = dsAbbreviation;
	}

}