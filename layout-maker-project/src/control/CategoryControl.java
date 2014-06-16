package control;

import dao.CategoryDao;
import java.sql.SQLException;
import model.Categoria;

public class CategoryControl {
    
    private CategoryDao dao;

    public CategoryControl() {
        
        this.dao = new CategoryDao();
        
    }
    
    public void insert(String cat_name) throws Exception, SQLException {

        Categoria cat = new Categoria(cat_name);

        this.dao.insert(cat);

    }
    
    public void delete(int id) throws Exception, SQLException {}
    
    public void update(int id, String cat_name) throws Exception, SQLException {}  
       
}
