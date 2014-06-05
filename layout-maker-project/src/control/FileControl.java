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
import view.FileWin;

public class FileControl {

    private FileDao fileDao;

    public FileControl() throws Exception, SQLException {

        this.fileDao = new FileDao();

    }

    public void insert(int id, String name, String ext, String file_name) throws Exception, SQLException {

        Arquivo file = new Arquivo(id, name, ext, file_name);
        
        this.fileDao.insert(file);

    }
    
    public void delete(int id) throws Exception, SQLException {
        
        Arquivo file = this.fileDao.getFile(id);
        
        File temp_file = new File( file.getDirectory());
        
        temp_file.delete();

        this.fileDao.delete(file);

    }

    public int getTheLastIDFile() throws Exception, SQLException {

        return this.fileDao.getTheLastIDFile();

    }
    
    public int getTheNextID() throws Exception, SQLException {
        
        return this.fileDao.getTheNextID();
        
    }
    
    public File getFileByID(int id) throws Exception, SQLException {
        
        Arquivo arquivo = this.fileDao.getFile(id);
        
        File file = new File( arquivo.getDirectory());

        return file;
        
    }
    
    public Arquivo getArquivoByID(int id) throws Exception, SQLException {

        return this.fileDao.getFile(id);
        
    }

    public List getAllFiles() throws Exception, SQLException {

        List files = this.fileDao.getAllFiles();

        return files;

    }

    public void loadingAllFilesInTable(JTable table) throws Exception, SQLException {

        List files = this.getAllFiles();
        Arquivo file;
        
        int size_list = files.size();

        if(size_list > 0) {
           
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
    
    public void loadValuesByID(FileWin win, int id) throws Exception, SQLException{
        
        Arquivo file = this.getArquivoByID(id);
        
        // Load ID
        win.getInput_id().setText( Integer.toString(id) );
        
        // Load file
        win.setFile( file.getDirectory());
        
        // Load file name
        win.getInput_name().setText( file.getName() );
        
        // Load extension
        win.getInput_ext().setText( file.getExtension() );
        
    }

}
