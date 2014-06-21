package dao;

import java.sql.SQLException;
import java.util.List;
import model.Framework;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Luiz
 */
public class FrameworkDao extends DefaultDao {
    
    public FrameworkDao() throws Exception, SQLException, HibernateException {
        
        this.setTable_reference("framework");
        
    }

    /**
     * Inserir
     * 
     * @param obj
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException 
     */
    public void insert(Framework obj) throws Exception, SQLException, HibernateException {

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
     * Deletar
     *
     * @param obj
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException
     */
    public void delete(Framework obj) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.delete(obj);

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
     * Atualizar
     *
     * @param obj
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException
     */
    public void update(Framework obj) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.update(obj);

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
     * Return all inserted objects.
     *
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public List<Framework> getAll() throws Exception, SQLException {

        List<Framework> list = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Framework");

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
     * Get object by ID
     *
     * @param id
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public Framework get(int id) throws Exception, SQLException {

        Framework comp = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL para recuperar o componente do banco de dados           
            Query con = this.session.createQuery("FROM Framework obj WHERE obj.id=" + id);

            con.setMaxResults(1);

            List<Framework> result = con.list();

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
     *
     * @param search
     * @return
     */
    public List search(String search) {

        List list = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Framework obj WHERE obj.nome LIKE '%" + search + "%' ");

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
     *
     * @param id
     * @return
     */
    public List search(int id) throws Exception, SQLException {

        List list = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Framework obj WHERE obj.id=" + id);

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
