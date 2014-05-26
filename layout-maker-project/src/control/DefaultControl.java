package control;

import dao.DefaultDao;
import java.sql.SQLException;

public class DefaultControl {
    /**
     * Default file directory
     */
    private String path_files;

    public DefaultControl() throws Exception, SQLException {
        
        DefaultDao dao = new DefaultDao();
        
        this.path_files = dao.getFilePath();
    }

    public String getPathFiles() {
        return path_files;
    }
    
    public void setPathFiles(String path_files) {
        this.path_files = path_files;
    }
    
}
