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
    
    public void insert(int id, String name, String ext) throws Exception, SQLException {
        
        Arquivo file = new Arquivo(id, name, ext);
        
        this.fileDao.insert(file);
        
    }
    
    public int getTheLastIDFile() throws Exception, SQLException {
        
        return this.fileDao.getTheLastIDFile();
        
    }
    
}
