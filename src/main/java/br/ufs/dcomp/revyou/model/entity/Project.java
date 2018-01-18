package br.ufs.dcomp.revyou.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.ufs.dcomp.revyou.enums.ReviewEnum;

@Entity
@Table(name = "project")
@XmlRootElement
@SequenceGenerator(name = "ProjectSequenceGenerator", sequenceName = "sq_project", allocationSize = 1)
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idProject;
	private String dsTitle;
	private String dsKey;
	private String dsProject;
	private ReviewEnum tpReview;

	public Project() {
	}

	public Project(String dsTitle, String dsKey, String dsProject, ReviewEnum tpReview) {
		this.dsTitle = dsTitle;
		this.dsKey = dsKey;
		this.dsProject = dsProject;
		this.tpReview = tpReview;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ProjectSequenceGenerator")
	@Column(name = "id_project", nullable = false, unique = true)
	public Long getIdProject() {
		return idProject;
	}

	public void setIdProject(Long idProject) {
		this.idProject = idProject;
	}

	@Column(name = "ds_key", nullable = false, unique = true)
	public String getDsKey() {
		return dsKey;
	}

	public void setDsKey(String dsKey) {
		this.dsKey = dsKey;
	}

	@Column(name = "ds_title", nullable = false)
	public String getDsTitle() {
		return dsTitle;
	}

	public void setDsTitle(String dsTitle) {
		this.dsTitle = dsTitle;
	}

	@Column(name = "ds_project")
	public String getDsProject() {
		return dsProject;
	}

	public void setDsProject(String dsProject) {
		this.dsProject = dsProject;
	}

	@Column(name = "tp_review", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public ReviewEnum getTpReview() {
		return tpReview;
	}

	public void setTpReview(ReviewEnum tpReview) {
		this.tpReview = tpReview;
	}
}