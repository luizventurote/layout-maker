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
import util.FileManager;
import view.FileWin;

public class FileControl {

    private FileDao fileDao;

    public FileControl() throws Exception, SQLException {

        this.fileDao = new FileDao();

    }
    
    public void insert(int id, String name, String ext, String directory, File file) throws Exception, SQLException {

        // Copy file
        FileManager.copyFile(file, "files/files/");

        // Get new file
        File temporary_file = new File("files/files/" + file.getName());

        // Rename file
        FileManager.renameFile(temporary_file, directory);

        // Remove temporary file
        temporary_file.delete();

        Arquivo obj = new Arquivo(id, name, ext, directory);

        this.fileDao.insert(obj);

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

        // Apaga o arquivo do repositório
        temp_file.delete();

        // Apaga o registro no banco
        this.fileDao.delete(file);

    }

    /**
     * Atualiza os dados do arquivo no banco de dados
     *
     * @param id ID do arquivo
     * @param file_name Nome personalizado do arquivo
     * @param file Fonte do arquivo
     * @param ext extensão do arquivo
     * @throws Exception
     * @throws SQLException
     */
    public void update(int id, String file_name, File file, String ext) throws Exception, SQLException {

        // Carrega o arquivo
        Arquivo arquivo = this.fileDao.getFile(id);

        // Arquivo fonte antigo
        File arquivo_old = file;

        // Altera o nome
        arquivo.setName(file_name);

        // Altera a extensão
        arquivo.setExtension(ext);

        // Gera um novo diretório
        arquivo.generateDirectory();

        // Gera um novo arquivo com o nome alterado
        FileManager.renameFile(file, arquivo.getDirectory());

        // Apaga o arquivo antigo
        arquivo_old.delete();

        // Atualiza o arquivo no banco
        this.fileDao.update(arquivo);

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

    private Arquivo getArquivoByID(int id) throws Exception, SQLException {

        return this.fileDao.getFile(id);

    }

    /**
     * Pega os dados de um arquivo pelo ID
     *
     * @param id ID do arquivo
     * @return arquivo Dados de um determinado arquivo
     * @throws Exception
     * @throws SQLException
     */
    public ArrayList getFileDataByID(int id) throws Exception, SQLException {

        ArrayList arquivo = new ArrayList();

        Arquivo file = this.getArquivoByID(id);

        arquivo.add(id);
        arquivo.add(file.getName());
        arquivo.add(file.getExtension());
        arquivo.add(file.getDirectory());

        return arquivo;

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
                table.setValueAt(file.getExtension(), linha, col++);
                table.setValueAt(file.getDirectory(), linha, col);

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

        File file = new File(ConfigControl.getInstance().getPathFiles() + file_name);

        return file.isFile();

    }

    /**
     * Verifica se um determinado arquivo existe no repositório de arquivos
     * através do ID
     *
     * @param id ID do arquivo
     * @return boolean
     */
    public boolean checkFileInRepository(int id) {

        return this.fileDao.checkFileInRepository(id);

    }

    /**
     * Exibe os dados pesquisados na tabela
     *
     * @param table Tabela de exibição dos dados
     * @param type tipo de pesquisa
     * @param search pesquisa
     * @throws Exception
     * @throws SQLException
     */
    public void search(JTable table, int type, String search) throws Exception, SQLException {

        List list = null;

        switch (type) {
            case 0: // Pesquisar ID
                int id = Integer.parseInt(search);
                list = fileDao.search(id);
                break;
            case 1: // Pesquisar Nome
                list = fileDao.search(search);
                break;
            case 2: // Pesquisar Extensão
                list = fileDao.searchExtension(search);
                break;
        }

        // Clean table
        for (int i = table.getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) table.getModel()).removeRow(i);
        }

        Arquivo file;

        int size_list = list.size();

        if (size_list > 0) {

            // Config table
            int linha = 0;
            int col = 0;

            Iterator<Arquivo> it = list.iterator(); //iterator
            while (it.hasNext()) {

                // New Arquivo
                file = it.next();

                // New line
                ((DefaultTableModel) table.getModel()).addRow(new Vector());
                table.setValueAt(file.getId(), linha, col++);
                table.setValueAt(file.getName(), linha, col++);
                table.setValueAt(file.getExtension(), linha, col++);
                table.setValueAt(file.getDirectory(), linha, col);

                // Reset number of columns
                col = 0;

                linha++;

            }

        }

    }

}
