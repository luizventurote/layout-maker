package dao;

import java.sql.SQLException;
import java.util.List;
import model.Arquivo;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class FileDao {

    Session session;

    public FileDao() throws Exception, SQLException, HibernateException {
    }

    public void insert(Arquivo file) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.save(file);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Arquivo file) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.delete(file);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(Arquivo file) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.update(file);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public int getTheLastIDFile() throws Exception, SQLException, HibernateException {

        int id = this.getTheNextID();

        return id - 1;

    }

    public int getTheNextID() {

        int id = 0;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createSQLQuery("SELECT AUTO_INCREMENT FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='layout_maker' AND TABLE_NAME='arquivo';");

            List result = con.list();

            id = Integer.parseInt(result.get(0).toString());

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            return id;
        }

    }

    /**
     * Get file by ID.
     *
     * @param id
     * @return Arquivo
     */
    public Arquivo getFile(int id) throws Exception, SQLException {

        Arquivo file = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Arquivo file WHERE file.id=" + id);

            con.setMaxResults(1);

            List<Arquivo> result = con.list();

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

    public List<Arquivo> getAllFiles() throws Exception, SQLException {

        List<Arquivo> files = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Arquivo");

            files = con.list();

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            return files;
        }

    }

    public boolean checkFileInRepository(int id) {

        int size = 0;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Arquivo file WHERE file.directory= LIKE '" + Integer.toString(id) + "_%'");

            size = con.list().size();

            // Quantidade de registros retornados
            int result_cont = con.list().size();

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }

            if (size > 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    public List search(String search) {
        
        List list = null;
        
        try {
            
            this.session = util.HibernateUtil.getSessionFactory().openSession();
            
            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Arquivo file WHERE file.name LIKE '%" + search + "%' ");
            
            list = con.list();

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            this.session.getTransaction().rollback();
        } finally {
            if (this.session != null) { this.session.close(); }
            return list;
        }

    }

    public List search(int id) {
        
        List list = null;
        
        try {
            
            this.session = util.HibernateUtil.getSessionFactory().openSession();
            
            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Arquivo file WHERE file.id="+id);
            
            list = con.list();

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            this.session.getTransaction().rollback();
        } finally {
            if (this.session != null) { this.session.close(); }
            return list;
        }
        
    }

    public List searchExtension(String ext) {
        
        List list = null;
        
        try {
            
            this.session = util.HibernateUtil.getSessionFactory().openSession();
            
            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Arquivo file WHERE file.extension='"+ext+"'");
            
            list = con.list();

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            this.session.getTransaction().rollback();
        } finally {
            if (this.session != null) { this.session.close(); }
            return list;
        }
        
    }

}
