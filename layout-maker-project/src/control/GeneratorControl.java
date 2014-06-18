package control;

import control.ComponentControl;
import control.ConfigControl;
import dao.ComponentDao;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        ConfigControl config_ctr = ConfigControl.getInstance();
        int size_table = table.getRowCount();
        int id;
        Componente com;
        Arquivo file;
        int qtd_file;
        List<Arquivo> files = new ArrayList();
        
        // Cria uma pasta temporária
        File tempPath = new File( config_ctr.getPathTempBuild() );
        tempPath.mkdir();
        
        for (int i = 0; i < size_table; i++) {
            
            // Recupera um componente
            id = Integer.parseInt( table.getValueAt(i, 0).toString() );
            com = dao.get(id);
            
            // Recupera os arquivos que estão relacionados ao componente
            files = dao.getArquivos(com);
            
            // Pega o diretório de cada arquivo
            int list_size = files.size();
            for (int j = 0; j < list_size; j++) {
                
                // Cria uma pasta para cada tipo de arquivo
                File extPath = new File( tempPath.getPath() +"\\"+ files.get(j).getExtension() );
                if( !extPath.isDirectory() ) {
                    extPath.mkdir();
                }
                
            }
            
        }
        
    }
    
}
