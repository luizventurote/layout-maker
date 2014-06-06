package control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import model.Arquivo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.FileWin;

public class FileControlTest {

    FileControl ctr;

    // Dados do arquivo
    int file_id;
    String file_name;
    String file_ext;
    String file_directory;

    @Before
    public void setUp() throws Exception {

        this.ctr = new FileControl();

        this.file_id = ctr.getTheNextID();
        this.file_name = "Teste";
        this.file_ext = "txt";
        this.file_directory = file_id + "_teste." + file_ext;

    }

    @Test
    public void testInsert() throws Exception {
        
        ArrayList arquivo;

        // Insere o arquivo no banco
        ctr.insert(this.file_id, this.file_name, this.file_ext, this.file_directory);
        
        // Pega os dados do arquivo no banco
        arquivo = ctr.getFileDataByID(this.file_id);
        
        // Verifica o ID
        assertEquals( arquivo.get(0) , this.file_id);
        
        // Verifica o nome
        assertEquals( arquivo.get(1) , this.file_name);
        
        // Verifica a extensão
        assertEquals( arquivo.get(2) , this.file_ext);
        
        // Verifica o diretório
        assertEquals( arquivo.get(3) , this.file_directory);

    }

}
