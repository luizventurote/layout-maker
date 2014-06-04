package model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ArquivoTest {
    
    Arquivo file;

    @Before
    public void testSetup() {
        
        int id = 10;
        String name = "Teste";
        String ext = "txt";
        String dir = "10_teste.txt";

        this.file = new Arquivo(id, name, ext, dir);
    }

    /**
     * Creation file
     */
    @Test
    public void testArquivo() {
        
        int id = this.file.getId();
        
        assertEquals(10, id);
        assertEquals("Teste", this.file.getName());
        assertEquals("txt", this.file.getExtension());
        assertEquals("10_teste.txt", this.file.getDirectory());
    }

}
