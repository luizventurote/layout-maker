package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArquivoTest {


    /**
     * Test of setFileName method, of class Arquivo.
     */
    @Test
    public void testArquivo() {
        
        Arquivo file;
        
        int id = 10;
        String ext = "txt";
        String base_name = "Teste";
        String nome = Integer.toString(id) + '_' + base_name + '.' + ext;
        
        
        //file = new Arquivo(id, base_name, ext);
        
    }
    
}
