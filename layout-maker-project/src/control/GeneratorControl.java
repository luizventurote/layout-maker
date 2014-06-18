package control;

import control.ComponentControl;
import dao.ComponentDao;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTable;
import model.Arquivo;
import model.Componente;

public class GeneratorControl {

    /**
     * Prepara os componentes para a compactação.
     * @param table_com 
     */
    public void buildComponents(JTable table) throws Exception {
        
        ComponentControl ctr = new ComponentControl();
        ComponentDao dao = new ComponentDao();
        
        int size_table = table.getRowCount();
        
        int id;
        Componente com;
        Arquivo file;
        int qtd_file;
        Set files;
        
        for (int i = 0; i < size_table; i++) {
            
            // Recupera um componente
            id = Integer.parseInt( table.getValueAt(i, 0).toString() );
            com = dao.get(id);
            
            System.out.println( com.getNome() );
            
            
            
//            if (com.getArquivos().isEmpty()) {
//                System.out.println("sim");
//            } else {
//                System.out.println("não");
//            }
            
            // Pega os arquivos do component
//            files = com.getArquivos();
//            
//            // Pega a quantidade de arquivos contidos no componente
//            qtd_file = files.size();
//            
//            System.out.println( qtd_file );
            
//            for (int j = 0; j < qtd_file; j++) {
//             
//                System.out.println( files. );
//                
//            }
            
        }
        
    }
    
}
