package dao;

import java.sql.SQLException;
import java.util.List;
import model.Componente;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class ComponentDao extends DefaultDao {

    /**
     * Insert Components
     *
     * @param obj
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException
     */
    public void insert(Componente obj) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.save(obj);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Deletar componente
     *
     * @param comp
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException
     */
    public void delete(Componente comp) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.delete(comp);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Atualizar componente
     *
     * @param comp
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException
     */
    public void update(Componente comp) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.update(comp);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Return all inserted components.
     *
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public List<Componente> getAll() throws Exception, SQLException {

        List<Componente> list = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Componente");

            list = con.list();

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            return list;
        }
    }

    /**
     * Get component by ID
     *
     * @param id
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public Componente get(int id) throws Exception, SQLException {

        Componente comp = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Componente comp WHERE comp.id=" + id);

            con.setMaxResults(1);

            List<Componente> result = con.list();

            comp = result.get(0);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            return comp;
        }
    }

    /**
     * Pesquisar por String
     * @param search
     * @return 
     */
    public List search(String search) {

        List list = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Componente comp WHERE comp.nome LIKE '%" + search + "%' ");

            list = con.list();

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            this.session.getTransaction().rollback();
        } finally {
            if (this.session != null) {
                this.session.close();
            }
            return list;
        }

    }

    /**
     * Pesquisa por ID
     * @param id
     * @return 
     */
    public List search(int id) {

        List list = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Componente comp WHERE comp.id=" + id);

            list = con.list();

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            this.session.getTransaction().rollback();
        } finally {
            if (this.session != null) {
                this.session.close();
            }
            return list;
        }

    }

}
