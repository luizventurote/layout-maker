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

        this.session = util.HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Arquivo file) throws Exception, SQLException, HibernateException {

        this.session.beginTransaction();

        this.session.save(file);

        this.session.getTransaction().commit();
        
    }

    public void delete(Arquivo file) throws Exception, SQLException, HibernateException {

        this.session.beginTransaction();

        this.session.delete(file);

        this.session.getTransaction().commit();

    }
    
    public void update(Arquivo file) throws Exception, SQLException, HibernateException {
        
        this.session.beginTransaction();

        this.session.update(file);

        this.session.getTransaction().commit();
        
    }

    public int getTheLastIDFile() throws Exception, SQLException, HibernateException {

        int id = this.getTheNextID();
        
        return id-1;

    }

    public int getTheNextID() {

        this.session.beginTransaction();

        // HQL           
        Query con = this.session.createSQLQuery("SELECT AUTO_INCREMENT FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='layout_maker' AND TABLE_NAME='arquivo';");

        List result = con.list();

        this.session.getTransaction().commit();
        
        return Integer.parseInt( result.get(0).toString() );

    }

    /**
     * Get file by ID.
     *
     * @param id
     * @return Arquivo
     */
    public Arquivo getFile(int id) throws Exception, SQLException {

        this.session.beginTransaction();

        // HQL           
        Query con = this.session.createQuery("FROM Arquivo file WHERE file.id=" + id);

        con.setMaxResults(1);

        List<Arquivo> result = con.list();

        this.session.getTransaction().commit();

        return result.get(0);
    }

    public List<Arquivo> getAllFiles() throws Exception, SQLException {

        this.session.beginTransaction();

        // HQL           
        Query con = this.session.createQuery("FROM Arquivo");

        List<Arquivo> files = con.list();

        this.session.getTransaction().commit();

        return files;
    }
    
    public boolean checkFileInRepository(int id) {
        
        this.session.beginTransaction();

        // HQL           
        Query con = this.session.createQuery("FROM Arquivo file WHERE file.directory= LIKE '"+id+"_%'");
        
        // Quantidade de registros retornados
        int result_cont = con.list().size();
        
        this.session.getTransaction().commit();
        
        if( con.list().size() > 0 ) {
            return true;
        } else {
            return false;
        }

    }

}
