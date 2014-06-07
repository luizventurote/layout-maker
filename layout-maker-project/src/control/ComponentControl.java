package control;

import dao.ComponentDao;

public class ComponentControl {
    
    ComponentDao dao;

    public ComponentControl() {
        
        this.dao = new ComponentDao();
        
    }
    
    /**
     * Pega o valor do próximo ID
     * @return valor do próximo ID
     */
    public int getTheNextID() {   
        return this.dao.getTheNextID();
    }
    
}
