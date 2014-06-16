package dao;

import java.sql.SQLException;
import model.Componente;
import org.hibernate.HibernateException;

public class ComponentDao extends DefaultDao{

    public ComponentDao() {
    
        this.setTable_reference("componente");
        
    }

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
    
    
}
