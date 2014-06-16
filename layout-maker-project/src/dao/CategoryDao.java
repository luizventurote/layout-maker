package dao;

import java.sql.SQLException;
import java.util.List;
import model.Categoria;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class CategoryDao extends DefaultDao {
    
    public void insert(Categoria cat) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.save(cat);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Categoria cat) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.delete(cat);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(Categoria cat) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.update(cat);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public List<Categoria> getAll() throws Exception, SQLException {

        List<Categoria> cat = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Categoria");

            cat = con.list();

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            return cat;
        }

    }
    
    public Categoria get(int id) throws Exception, SQLException {

        Categoria file = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Categoria cat WHERE cat.id=" + id);

            con.setMaxResults(1);

            List<Categoria> result = con.list();

            file = result.get(0);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            return file;
        }
    }
    
}
