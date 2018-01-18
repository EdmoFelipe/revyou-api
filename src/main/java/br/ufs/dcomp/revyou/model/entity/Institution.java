package br.ufs.dcomp.revyou.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "institution")
@XmlRootElement
@SequenceGenerator(name = "InstitutionSequenceGenerator", sequenceName = "sq_institution", allocationSize = 1)
public class Institution implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long idInstitution;
	private String dsAbbreviation;
	private String nmInstitution;
	private Country country;
	private Project project;

	public Institution() {
	}

	public Institution(String nmInstitution, String dsAbbreviation, Country country) {
		super();
		this.nmInstitution = nmInstitution;
		this.dsAbbreviation = dsAbbreviation;
		this.country = country;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "InstitutionSequenceGenerator")
	@Column(name = "id_institution", nullable = false, unique = true)
	public Long getIdInstitution() {
		return idInstitution;
	}

	public void setIdInstitution(Long idInstitution) {
		this.idInstitution = idInstitution;
	}

	@Column(name = "ds_abbreviation", nullable = false)
	public String getDsAbbreviation() {
		return dsAbbreviation;
	}

	public void setDsAbbreviation(String dsAbbreviation) {
		this.dsAbbreviation = dsAbbreviation;
	}

	@Column(name = "nm_institution", nullable = false)
	public String getNmInstitution() {
		return nmInstitution;
	}

	public void setNmInstitution(String nmInstitution) {
		this.nmInstitution = nmInstitution;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_country", nullable = false)
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project", nullable = false)
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
