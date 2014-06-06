package control;

import model.Config;

/**
 * Essa classe implementa o padrão de projeto Singleton.
 */
public class ConfigControl {
    
    private Config config;
    
    /**
     * Variável que recebe a instância da classe
     */
    private static ConfigControl instance = new ConfigControl();

    private ConfigControl() {
     
        this.config = new Config();
        this.config.setPathFiles("files/files/");
        
    }

    public static ConfigControl getInstance() {
        return instance;
    }
    
    /**
     * Retorna o diretório de arquivos
     * @return String
     */
    public String getPathFiles() {
        return this.config.getPathFiles();
    }
    
}
