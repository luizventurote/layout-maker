package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.*;

public class DefaultDao {

    Statement stmt;
    Session sess = null;

    public DefaultDao() throws Exception, SQLException {

        /**
         * Start new hibernate session
         */
        //this.sess = util.HibernateUtil.getSessionFactory().openSession();
        //this.sess.beginTransaction();

    }

    public void insert(Object obj) {

        try {
            this.sess.save(obj);
            this.sess.getTransaction().commit();
            
        } catch (HibernateException he) {
            this.sess.getTransaction().rollback();
            
        } finally {
            if (this.sess != null) {
                this.sess.close();
            }
        }

    }

    /**
     * Get default file directory
     *
     * @return String
     * @throws Exception
     * @throws SQLException
     */
    public String getFilePath() throws Exception, SQLException {

        ResultSet rs;
        String path_files = "";

        // SQL que retorna o último ID
        String sql = "SELECT * FROM config LIMIT 1;";

        // Consulta no banco
        rs = this.stmt.executeQuery(sql);

        // Create new file
        while (rs.next()) {
            path_files = rs.getString(2);
        }

        return path_files;
    }

}
