package control;

import dao.ConfigDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Config;

/**
 * Essa classe implementa o padrão de projeto Singleton.
 */
public class ConfigControl {

    private Config config;
    private ConfigDao dao;

    /**
     * Variável que recebe a instância da classe
     */
    private static ConfigControl instance = new ConfigControl();

    private ConfigControl() {

        try {

            this.dao = new ConfigDao();

            this.config = dao.get(1);

        } catch (Exception ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ConfigControl getInstance() {
        return instance;
    }

    /**
     * Inserir
     *
     * @throws Exception
     * @throws SQLException
     */
    public void insert(String file_path, String lib_path, String fwk_path) throws Exception, SQLException {

        this.config = new Config();
        this.config.setPathFiles(file_path);

        dao.insert(this.config);

    }

    /**
     * Update
     */
    public void update(String file_path, String lib_path, String fwk_path) throws Exception, SQLException {

        this.config = dao.get(1);
        this.config.setPathFiles(file_path);

        dao.update(this.config);

    }

    /**
     * Retorna o diretório de arquivos
     *
     * @return String
     */
    public String getPathFiles() {
        return this.config.getPathFiles();
    }

    /**
     * Retorna o diretório da pasta temporária
     *
     * @return String
     */
    public String getPathTempBuild() {
        return this.config.getPathTempBuild();
    }

}
