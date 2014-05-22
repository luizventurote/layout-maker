package control;

import dao.FileDao;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Arquivo;

public class FileControl {

    FileDao fileDao;

    public FileControl() throws Exception, SQLException {

        fileDao = new FileDao();

    }

    public void insert(int id, String name, String ext, String file_name) throws Exception, SQLException {

        Arquivo file = new Arquivo(id, name, ext, file_name);
        
        this.fileDao.insert(file);

    }
    
    public void delete(int id) throws Exception, SQLException {

        this.fileDao.delete(id);

    }

    public int getTheLastIDFile() throws Exception, SQLException {

        return this.fileDao.getTheLastIDFile();

    }
    
    public File getFileByID(int id) {
        
        
        return null;
    }

    public ArrayList getAllFiles() throws Exception, SQLException {

        ArrayList files = new ArrayList();

        files = this.fileDao.getAllFiles();

        return files;

    }

    public void loadingAllFilesInTable(JTable table) throws Exception, SQLException {

        ArrayList files = new ArrayList();
        files = this.getAllFiles();
        Arquivo file;

        // Config table
        int linha = 0;
        int col = 0;        

        Iterator<Arquivo> it = files.iterator(); //iterator
        while (it.hasNext()) {
            
            // New Arquivo
            file =  it.next();
            
            // New line
            ((DefaultTableModel) table.getModel()).addRow(new Vector());
            table.setValueAt(file.getId(), linha, col++);
            table.setValueAt(file.getName(), linha, col++);
            table.setValueAt(file.getExtension(), linha, col);
            
            // Reset number of columns
            col = 0;
        
            linha++;
            
        }

    }

}
