package br.ufs.dcomp.revyou.model.dto;

import br.ufs.dcomp.revyou.model.entity.Country;

public class CountryCreatedDto {

	private String nmCountry;
	private Long idCountry;

	public CountryCreatedDto(Country country) {
		this.nmCountry = country.getNmCountry();
		this.idCountry = country.getIdCountry();
	}

	public String getNmCountry() {
		return nmCountry;
	}

	public void setNmCountry(String nmCountry) {
		this.nmCountry = nmCountry;
	}

	public Long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}

}