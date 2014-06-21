package control;

import dao.CategoryDao;
import dao.FrameworkDao;
import dao.FileDao;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Framework;

/**
 *
 * @author Luiz
 */
public class FrameworkControl {
    
    FrameworkDao dao;
    Framework frame;
    
    public FrameworkControl() throws Exception, SQLException {

        this.dao = new FrameworkDao();
        
    }
    
    /**
     * Inserir
     * @param name
     * @throws Exception
     * @throws SQLException 
     */
    public void insert(String name) throws Exception, SQLException {

        this.frame = new Framework();
        this.frame.setNome(name);

        dao.insert(this.frame);

    }
    
    /**
     * Delete
     *
     * @param id
     * @throws Exception
     * @throws SQLException
     */
    public void delete(int id) throws Exception, SQLException {

        // Pega os dados do objeto a partir do ID
        Framework comp = this.dao.get(id);

        // Apaga o registro no banco
        this.dao.delete(comp);

    }
    
    /**
     * Pega o valor do próximo ID
     *
     * @return valor do próximo ID
     */
    public int getTheNextID() {
        return this.dao.getTheNextID();
    }
    
    /**
     * Return all inserted Objects.
     */
    private List getAll() throws Exception, SQLException {

        return dao.getAll();

    }
    
    /**
     * Exibe os dados pesquisados na tabela
     *
     * @param table Tabela de exibição dos dados
     * @param type tipo de pesquisa
     * @param search pesquisa
     * @throws Exception
     * @throws SQLException
     */
    public void search(JTable table, int type, String search) throws Exception, SQLException {

        List list = null;

        switch (type) {
            case 0: // Pesquisar ID
                int id = Integer.parseInt(search);
                list = dao.search(id);
                break;
            case 1: // Pesquisar Nome
                list = dao.search(search);
                break;
        }

        // Clean table
        for (int i = table.getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) table.getModel()).removeRow(i);
        }

        Framework file;

        int size_list = list.size();

        if (size_list > 0) {

            // Config table
            int linha = 0;
            int col = 0;

            Iterator<Framework> it = list.iterator(); //iterator
            while (it.hasNext()) {

                // New Arquivo
                file = it.next();

                // New line
                ((DefaultTableModel) table.getModel()).addRow(new Vector());
                table.setValueAt(file.getId(), linha, col++);
                table.setValueAt(file.getNome(), linha, col);

                // Reset number of columns
                col = 0;

                linha++;

            }

        }

    }
    
}
