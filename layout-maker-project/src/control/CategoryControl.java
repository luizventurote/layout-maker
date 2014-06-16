package control;

import dao.CategoryDao;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Categoria;

public class CategoryControl {

    private CategoryDao dao;
    Categoria cat;

    public CategoryControl() {

        this.dao = new CategoryDao();

    }

    public void insert(String cat_name) throws Exception, SQLException {

        Categoria cat = new Categoria(cat_name);

        this.dao.insert(cat);

    }

    public void delete(int id) throws Exception, SQLException {

        this.cat = dao.get(id);

        dao.delete(cat);

    }

    public void update(int id, String cat_name) throws Exception, SQLException {

        this.cat = dao.get(id);

        dao.update(cat);

    }

    public void loadingATable(JTable table) throws Exception, SQLException {

        List categorias = this.getAll();
        Categoria cat;

        int size_list = categorias.size();

        if (size_list > 0) {

            // Config table
            int linha = 0;
            int col = 0;

            Iterator<Categoria> it = categorias.iterator(); //iterator
            while (it.hasNext()) {

                // New Arquivo
                cat = it.next();

                // New line
                ((DefaultTableModel) table.getModel()).addRow(new Vector());
                table.setValueAt(cat.getId(), linha, col++);
                table.setValueAt(cat.getNome(), linha, col);

                // Reset number of columns
                col = 0;

                linha++;

            }

        }

    }

    public List getAll() throws Exception, SQLException {

        List categories = this.dao.getAll();

        return categories;

    }

    public void refreshTable(JTable table) throws Exception {

        // Clean selection
        table.clearSelection();

        // Clean table
        for (int i = table.getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) table.getModel()).removeRow(i);
        }

        // Loading files in the table
        this.loadingATable(table);

    }

}
