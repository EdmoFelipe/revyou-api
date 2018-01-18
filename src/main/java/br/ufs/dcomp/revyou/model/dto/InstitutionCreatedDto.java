package br.ufs.dcomp.revyou.model.dto;

import br.ufs.dcomp.revyou.model.entity.Country;
import br.ufs.dcomp.revyou.model.entity.Institution;

public class InstitutionCreatedDto {

	private String dsAbbreviation;
	private String nmInstitution;
	private String nmCountry;
	private Long idInstitution;
	private Country country;
	private String dsKey;

	public InstitutionCreatedDto() {
	}

	public InstitutionCreatedDto(Institution institution) {
		super();
		this.dsAbbreviation = institution.getDsAbbreviation();
		this.nmInstitution = institution.getNmInstitution();
		this.nmCountry = institution.getCountry().getNmCountry();
		this.idInstitution = institution.getIdInstitution();
	}

	public Long getIdInstitution() {
		return idInstitution;
	}

	public void setIdInstitution(Long idInstitution) {
		this.idInstitution = idInstitution;
	}

	public String getDsAbbreviation() {
		return dsAbbreviation;
	}

	public void setDsAbbreviation(String dsAbbreviation) {
		this.dsAbbreviation = dsAbbreviation;
	}

	public String getNmInstitution() {
		return nmInstitution;
	}

	public void setNmInstitution(String nmInstitution) {
		this.nmInstitution = nmInstitution;
	}

	public String getNmCountry() {
		return nmCountry;
	}

	public void setNmCountry(String nmCountry) {
		this.nmCountry = nmCountry;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getDsKey() {
		return dsKey;
	}

	public void setDsKey(String dsKey) {
		this.dsKey = dsKey;
	}

}