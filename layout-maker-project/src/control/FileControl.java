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

    /**
     * Deleta o arquivo e exclui o seu registro no banco de dados
     *
     * @param id ID do arquivo que será excluído
     * @throws Exception
     * @throws SQLException
     */
    public void delete(int id) throws Exception, SQLException {

        // Pega os dados do arquivo a partir do ID
        Arquivo file = this.fileDao.getFile(id);
        
        // Monta o arquivo passando o diretório de arquivos mais o nome do arquivo
        File temp_file = new File(ConfigControl.getInstance().getPathFiles() + file.getDirectory());

        // Verifica se o arquivo realmente existe no repositório
        if (temp_file.isFile()) {
            
            // Apaga o arquivo do repositório
            temp_file.delete();

            // Apaga o registro no banco
            this.fileDao.delete(file);
        } else {
            throw new Exception("O arquivo não foi encontrado!");
        }

    }
    
    /**
     * Atualiza os dados do arquivo no banco de dados
     * 
     * @param id ID do arquivo
     * @param file_name Nome personalizado do arquivo
     * @param file_directory Diretório onde se encontra o arquivo
     * @throws Exception
     * @throws SQLException 
     */
    public void update(int id, String file_name, File file) throws Exception, SQLException {
        
        // Carrega o arquivo antigo
        Arquivo file_old = this.fileDao.getFile(id);
        
        System.out.println("");
        
        System.out.println( file_old.getDirectory() );
        
        System.out.println( id );
        
        System.out.println(file_name);
        
        System.out.println( file.getAbsoluteFile() );
        
        System.out.println("");
        
        if( this.checkFileInRepository( file.getName() ) ) {
            System.out.println("O arquivo já existe");
        } else {
            System.out.println("Não existe");
        }
        
        System.out.println("============================");
        
        //System.out.println( this.checkFileInRepository(id) );
        
    }

    public int getTheLastIDFile() throws Exception, SQLException {

        return this.fileDao.getTheLastIDFile();

    }

    public int getTheNextID() throws Exception, SQLException {

        return this.fileDao.getTheNextID();

    }

    public File getFileByID(int id) throws Exception, SQLException {

        Arquivo arquivo = this.fileDao.getFile(id);

        File file = new File(arquivo.getDirectory());

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

        if (size_list > 0) {

            // Config table
            int linha = 0;
            int col = 0;

            Iterator<Arquivo> it = files.iterator(); //iterator
            while (it.hasNext()) {

                // New Arquivo
                file = it.next();

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

    public void loadValuesByID(FileWin win, int id) throws Exception, SQLException {

        Arquivo file = this.getArquivoByID(id);

        // Load ID
        win.getInput_id().setText(Integer.toString(id));

        // Load file
        win.setFile(ConfigControl.getInstance().getPathFiles() + file.getDirectory());

        // Load file name
        win.getInput_name().setText(file.getName());

        // Load extension
        win.getInput_ext().setText(file.getExtension());

    }
    
    /**
     * Verifica se um determinado arquivo existe no repositório de arquivos.
     * 
     * @param file_name Nome do arquivo a ser verificado
     * @return boolean
     */
    public boolean checkFileInRepository(String file_name) {
        
        File file = new File( ConfigControl.getInstance().getPathFiles() + file_name );
        
        return file.isFile();
        
    }
    
    /**
     * Verifica se um determinado arquivo existe no repositório de arquivos através do ID
     * 
     * @param id ID do arquivo
     * @return boolean
     */
    public boolean checkFileInRepository(int id) {
        
        return this.fileDao.checkFileInRepository(id);
        
    }

}
