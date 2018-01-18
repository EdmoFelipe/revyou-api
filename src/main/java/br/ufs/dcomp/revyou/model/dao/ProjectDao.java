package br.ufs.dcomp.revyou.model.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.revyou.model.entity.Project;

/**
 * @author farms
 *
 */
@Component
public class ProjectDao extends HibernateDao<Project> {

	/**
	 * Indicates the entity type to Hibernate.
	 */
	public ProjectDao() {
		super(Project.class);
	}

	/**
	 * Search a project by dsKey.
	 * 
	 * @param dsKey
	 * @return
	 */
	public Project getByDsKey(String dsKey) {
		Query<Project> query = getSession().createQuery("from Project p where lower(p.dsKey) = :dsKey", Project.class);
		query.setParameter("dsKey", dsKey.toLowerCase());
		List<Project> results = query.list();
		return (results != null && !results.isEmpty()) ? (Project) results.get(0) : null;
	}
	
	public List<Project> getProjects() {
		Query<Project> query = getSession().createQuery("from Project p order by p.dsTitle", Project.class);
		return query.list();
	}
}
