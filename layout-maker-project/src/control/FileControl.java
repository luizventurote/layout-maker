package control;

import dao.FileDao;
import java.io.File;
import java.sql.SQLException;
import model.Arquivo;

public class FileControl {
    
    FileDao fileDao;

    public FileControl() throws Exception, SQLException {
        
        fileDao = new FileDao();
        
    }
    
    public void addFile(String name, File file) throws Exception, SQLException {
        
        Arquivo new_file = new Arquivo(name, file);
        
        this.fileDao.insert(new_file);
        
    }
    
}
