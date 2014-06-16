package control;

import dao.CategoryDao;
import dao.ComponentDao;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Componente;

public class ComponentControl {

    ComponentDao dao;
    CategoryDao cat_dao;
    Componente comp;

    public ComponentControl() {

        this.dao = new ComponentDao();
        this.cat_dao = new CategoryDao();

    }

    public void insert(String name, String cat) throws Exception, SQLException {

        // Busca o objeto categoria a partir do nome
        Categoria category = cat_dao.getObj(cat);

        comp = new Componente();
        comp.setNome(name);
        comp.setCategoria(category);

        dao.insert(comp);

    }
    
    /**
     * Deleta o componente
     * @param id
     * @throws Exception
     * @throws SQLException 
     */
    public void delete(int id) throws Exception, SQLException {

        // Pega os dados do arquivo a partir do ID
        Componente comp = this.dao.get(id);

        // Apaga o registro no banco
        this.dao.delete(comp);

    }
    
    /**
     * Atualiza o componente
     * @param id
     * @throws Exception
     * @throws SQLException 
     */
    public void insert(int id) throws Exception, SQLException {
        
        // Pega os dados do arquivo a partir do ID
        Componente comp = this.dao.get(id);

        dao.update(comp);

    }

    /**
     * Pega o valor do próximo ID
     *
     * @return valor do próximo ID
     */
    public int getTheNextID() {
        return this.dao.getTheNextID();
    }

    public void loadCombo(JComboBox combo) throws Exception, SQLException {

        List<Categoria> lista = cat_dao.getAll();

        combo.setModel(new DefaultComboBoxModel(lista.toArray()));

    }

    public void loadTable(JTable table) throws Exception, SQLException {

        List components = this.getAll();
        Componente comp;

        int size_list = components.size();

        if (size_list > 0) {

            // Config table
            int linha = 0;
            int col = 0;

            Iterator<Componente> it = components.iterator(); //iterator
            while (it.hasNext()) {

                comp = it.next();

                // New line
                ((DefaultTableModel) table.getModel()).addRow(new Vector());
                table.setValueAt(comp.getId(), linha, col++);
                table.setValueAt(comp.getNome(), linha, col);

                // Reset number of columns
                col = 0;

                linha++;

            }

        }

    }

    /**
     * Return all inserted components.
     */
    private List getAll() throws Exception, SQLException {

        return dao.getAll();

    }

}
