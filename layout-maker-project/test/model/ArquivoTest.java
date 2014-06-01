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
        String file_name = "10_teste.txt";

        this.file = new Arquivo(id, name, ext, file_name);
    }

    /**
     * Creation file
     */
    @Test
    public void testArquivo() {
        assertEquals(10, this.file.getId());
        assertEquals("Teste", this.file.getName());
        assertEquals("txt", this.file.getExtension());
        assertEquals("10_teste.txt", this.file.getFileName());
    }

}
