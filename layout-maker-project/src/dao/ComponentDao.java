package dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Arquivo;
import model.Componente;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class ComponentDao extends DefaultDao {

    FileDao file_dao;

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

            // HQL para recuperar o componente do banco de dados           
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
     * Get component and your files by ID
     *
     * @param id
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public Componente get(int id, boolean arq) throws Exception, SQLException {

        Componente comp = null;

        this.file_dao = new FileDao();

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL para recuperar o componente do banco de dados           
            Query con = this.session.createQuery("FROM Componente comp WHERE comp.id=" + id);

            con.setMaxResults(1);

            List<Componente> result = con.list();

            comp = result.get(0);

            // Recupera os arquivos relacionado ao componente
            if (arq) {

                con = this.session.createSQLQuery("SELECT arquivo_id FROM componente_arquivo WHERE componente_id = " + id);

                List file_result = con.list();

                int id_file;
                Arquivo file;
                Set set = new HashSet(file_result);

                // Quantidade de arquivos
                int file_list_size = file_result.size();
                
                System.out.println( file_list_size );

                for (int i = 0; i < file_list_size; i++) {

                    id_file = Integer.parseInt(file_result.get(i).toString());

                    file = this.file_dao.getFile(id_file);

                    set.add(file);

                }

                comp.setArquivos(set);

            }

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

    /**
     * Recupera os arquivos relacionados ao arquivo
     *
     * @param com
     * @return
     */
    public List getArquivos(Componente com) throws Exception, SQLException {

        List<Arquivo> list = null;

        try {
            
            list = new ArrayList();

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            Query con = this.session.createSQLQuery("SELECT arquivo_id FROM componente_arquivo WHERE componente_id = " + com.getId());

            List file_result = con.list();

            int id_file;
            Arquivo file;
            Set set = new HashSet(file_result);
            
            file_dao = new FileDao();

            // Quantidade de arquivos
            int file_list_size = file_result.size();

            for (int i = 0; i < file_list_size; i++) {

                id_file = Integer.parseInt(file_result.get(i).toString());

                file = this.file_dao.getFile(id_file);

                list.add(file);

            }

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
