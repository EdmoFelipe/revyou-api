package br.ufs.dcomp.revyou.model.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.revyou.model.entity.Country;
import br.ufs.dcomp.revyou.model.entity.Institution;

/**
 * @author farms
 *
 */
@Component
public class InstitutionDao extends HibernateDao<Institution> {

    /**
     * Constructor from superclass.
     *
     */
    public InstitutionDao() {
        super(Institution.class);
    }

    /**
     * Returns all institutions from the specified project.
     *
     * @param dsKey the identifier of the project.
     * @return a list of all the institutions of the specified project.
     */
    public List<Institution> getByDsKeyProject(String dsKey) {
        StringBuilder sbHql = new StringBuilder();
        sbHql.append("from Institution i");
        sbHql.append(" join fetch i.project p");
        sbHql.append(" where p.dsKey like :dsKey");

        Query<Institution> q = getSession().createQuery(sbHql.toString(), Institution.class);
        q.setParameter("dsKey", dsKey);

        List<Institution> institutions = q.list();

        return institutions;
    }

    /**
     * Returns all institutions
     *
     * @return a list of all the institutions
     */
    public List<Institution> getAllInstitutions() {
        StringBuilder sbHql = new StringBuilder();
        sbHql.append("from Institution i");

        Query<Institution> q = getSession().createQuery(sbHql.toString(), Institution.class);

        List<Institution> institutions = q.list();
        return institutions;
    }

    /**
     * Get all registered countries.
     *
     * @return List of all countries registered.
     */
    public List<Country> getAllCountries() {
        StringBuilder sbHql = new StringBuilder();
        sbHql.append("from Country c");

        Query<Country> q = getSession().createQuery(sbHql.toString(), Country.class);

        List<Country> countries = q.list();
        return countries;
    }

    public Institution getByName(String nmInstitution, Long idProject) {
        Query<Institution> query = getSession().createQuery(
                "from Institution i where i.project.idProject = :idProject and lower(i.nmInstitution) = :nmInstitution", Institution.class);
        query.setParameter("idProject", idProject);
        query.setParameter("nmInstitution", nmInstitution.toLowerCase());
        List<Institution> results = query.list();
        return (results != null && !results.isEmpty()) ? (Institution) results.get(0) : null;
    }

    /**
     * Delete institution from project
     *
     * @param idProject
     * @param idInstitution
     */
    public void deleteInstitution(Long idProject, Long idInstitution) {
        Transaction transaction = getSession().beginTransaction();
        try {

            String hql = "delete from Institution where project.idProject= :idProject and idInstitution =:idInstitution";
            Query<?> query = getSession().createQuery(hql);
            query.setParameter("idProject", idProject);
            query.setParameter("idInstitution", idInstitution);
            query.executeUpdate();

            transaction.commit();
        } catch (Throwable t) {
            transaction.rollback();
            throw t;
        }
    }

    /**
     * Count institutions of a project
     *
     * @param idProject
     * @return
     */
    public Long countInstitutions(Long idProject) {
        Query<Long> query = getSession().createQuery("select count(*) from Institution where project.idProject= :idProject", Long.class);
        query.setParameter("idProject", idProject);
        return query.uniqueResult();
    }
}
