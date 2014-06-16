package control;

import dao.CategoryDao;
import dao.ComponentDao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
        Categoria category = cat_dao.getObj( cat );
         
        comp = new Componente();
        comp.setNome(name);
        comp.setCategoria(category);
        
        dao.insert(comp);
         
    }
    
    /**
     * Pega o valor do próximo ID
     * @return valor do próximo ID
     */
    public int getTheNextID() {   
        return this.dao.getTheNextID();
    }
    
    public void loadCombo(JComboBox combo) throws Exception, SQLException {
        
        List<Categoria> lista = cat_dao.getAll();
        
        combo.setModel( new DefaultComboBoxModel( lista.toArray() ) );
        
    }
    
}
