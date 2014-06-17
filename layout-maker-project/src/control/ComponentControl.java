package control;

import dao.CategoryDao;
import dao.ComponentDao;
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
import model.Arquivo;
import model.Categoria;
import model.Componente;

public class ComponentControl {

    ComponentDao dao;
    CategoryDao cat_dao;
    FileDao file_dao;
    Componente comp;

    public ComponentControl() throws Exception, SQLException {

        this.dao = new ComponentDao();
        this.cat_dao = new CategoryDao();
        this.file_dao = new FileDao();

    }

    public void insert(String name, String cat, JTable table) throws Exception, SQLException {

        // Busca o objeto categoria a partir do nome
        Categoria category = cat_dao.getObj(cat);

        comp = new Componente();
        comp.setNome(name);
        comp.setCategoria(category);
        
        // Insere os arquivos ao componente
        int qtd_row = table.getRowCount();
        
        int id;
        
        Set<Arquivo> arquivos = new HashSet(0);
        
        Arquivo file;
                
        for (int i = 0; i < qtd_row; i++) {

            // Recupera um arquivo pelo ID e adicona na lista 
            id = Integer.parseInt( table.getValueAt(i, 0).toString() );
            file = this.file_dao.getFile( id );
            arquivos.add( file );

        }
        
        comp.setArquivos(arquivos);

        dao.insert(comp);

    }

    /**
     * Deleta o componente
     *
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
     *
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

        Componente file;

        int size_list = list.size();

        if (size_list > 0) {

            // Config table
            int linha = 0;
            int col = 0;

            Iterator<Componente> it = list.iterator(); //iterator
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

    /**
     * Adiciona itens na tabela
     *
     * @param list
     */
    public void addItemTable(JTable table, List files_id) throws Exception, SQLException {

        file_dao = new FileDao();

        int id;

        Arquivo file;

        int size_list = files_id.size();

        if (size_list > 0) {;

            // Config table
            int linha = table.getRowCount();
            int col = 0;

            for (int i = 0; i < size_list; i++) {

                id = Integer.parseInt(files_id.get(i).toString());

                if (this.SearchIdInTable(table, id)) { 

                } else {

                    file = file_dao.getFile(id);

                    // New line
                    ((DefaultTableModel) table.getModel()).addRow(new Vector());
                    table.setValueAt(file.getId(), linha, col++);
                    table.setValueAt(file.getName(), linha, col++);
                    table.setValueAt(file.getExtension(), linha, col++);
                    table.setValueAt(file.getDirectory(), linha, col);

                    // Reset number of columns
                    col = 0;

                    linha++;

                }
            }
        }
    }

    /**
     * Procura por um ID na lista de IDs
     *
     * @param table
     * @return
     */
    public boolean SearchIdInList(List list, int id) {

        // Pega a quantidade de linhas
        int size = list.size();

        // Lista de IDs
        List id_list = null;

        for (int i = 0; i < size; i++) {

            if (Integer.parseInt(list.get(i).toString()) == id) {
                return true;
            }

        }

        return false;

    }
    
    /**
     * Procura por um ID na tabela
     * @param table
     * @param id
     * @return 
     */
    public boolean SearchIdInTable(JTable table, int id) {
        
        int qtd_row = table.getRowCount();
                
        for (int i = 0; i < qtd_row; i++) {

            if( id == Integer.parseInt( table.getValueAt(i, 0).toString() ) ) {
                return true;
            }
        }
        
        return false;
        
    }

    /**
     * Remove o relacionamento entre um Componente e um Arquivo
     * @param id 
     */
    public void removeFile(int id) throws Exception, SQLException {
        
        
        
    }

}
