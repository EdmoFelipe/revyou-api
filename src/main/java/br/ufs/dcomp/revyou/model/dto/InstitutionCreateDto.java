package br.ufs.dcomp.revyou.model.dto;

import br.ufs.dcomp.revyou.model.entity.Country;

public class InstitutionCreateDto {

	private String dsAbbreviation;
	private String nmInstitution;
	private Country country;
	private String dsKey;

	public InstitutionCreateDto() {
	}

	public InstitutionCreateDto(String dsAbbreviation, String nmInstitution, Country country, String dsKey) {
		super();
		this.dsAbbreviation = dsAbbreviation;
		this.nmInstitution = nmInstitution;
		this.country = country;
		this.dsKey = dsKey;
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

	public Country getCountry() {
		return country;
	}

	public void setIdCountry(Country country) {
		this.country = country;
	}

	public String getDsKey() {
		return dsKey;
	}

	public void setDsKey(String dsKey) {
		this.dsKey = dsKey;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}