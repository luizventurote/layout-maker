package control;

import dao.ComponentDao;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import model.Arquivo;
import model.Componente;
import util.FileManager;
import util.FolderZiper;

public class GeneratorControl {

    /**
     * Prepara os componentes para a compactação.
     *
     * @param table
     * @throws java.lang.Exception
     */
    public void buildComponents(JTable table) throws Exception {

        ComponentControl ctr = new ComponentControl();
        ComponentDao dao = new ComponentDao();
        ConfigControl config_ctr = ConfigControl.getInstance();
        int size_table = table.getRowCount();
        int id;
        Componente com;
        Arquivo file;
        int qtd_file;
        List<Arquivo> files;

        // Cria uma pasta temporária
        File tempPath = File.createTempFile( "layout_", "");
        if (!(tempPath.delete())) {
            throw new IOException("Could not delete temp file: " + tempPath.getAbsolutePath());
        }
        if (!(tempPath.mkdir())) {
            throw new IOException("Could not create temp directory: " + tempPath.getAbsolutePath());
        }

        for (int i = 0; i < size_table; i++) {

            // Recupera um componente
            id = Integer.parseInt(table.getValueAt(i, 0).toString());
            com = dao.get(id);

            // Recupera os arquivos que estão relacionados ao componente
            files = dao.getArquivos(com);

            // Pega o diretório de cada arquivo
            int list_size = files.size();
            for (int j = 0; j < list_size; j++) {

                Arquivo arquivo = files.get(j);

                // Cria uma pasta para cada tipo de arquivo
                File extPath = new File(tempPath.getPath() + "\\" + arquivo.getExtension());
                if (!extPath.isDirectory()) {
                    extPath.mkdir();
                }

                File tempArquivo = new File(config_ctr.getPathFiles() + arquivo.getDirectory());

                // Salva o arquivo em sua pasta de acrodo com a extenssão
                FileManager.copyFile(tempArquivo, extPath.getPath() + "\\", com.getId() + "_" + com.getNome().replace(" ", "_").toLowerCase() + "." +arquivo.getExtension() );

            }
        }

        // Compactação dos arquivos
        FolderZiper.zipFolder(tempPath.getPath(), "files/layout.zip");

    }

}
