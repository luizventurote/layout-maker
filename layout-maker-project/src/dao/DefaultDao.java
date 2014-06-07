package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class DefaultDao {
    
    Session session;
    
    private String table_reference;
    
    /**
     * Pega o valor do próximo ID
     * @return Valor do próximo ID
     */
    public int getTheNextID() {

        int id = 0;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createSQLQuery("SELECT AUTO_INCREMENT FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='layout_maker' AND TABLE_NAME='"+this.table_reference+"';");

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

    public String getTable_reference() {
        return table_reference;
    }

    public void setTable_reference(String table_reference) {
        this.table_reference = table_reference;
    }

    
}
