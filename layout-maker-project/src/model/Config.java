package model;
// Generated Jun 7, 2014 1:46:42 AM by Hibernate Tools 3.6.0



/**
 * Config generated by hbm2java
 */
public class Config  implements java.io.Serializable {


     private int idConfig;
     private String pathFiles;

    public Config() {
    }

	
    public Config(int idConfig) {
        this.idConfig = idConfig;
    }
    public Config(int idConfig, String pathFiles) {
       this.idConfig = idConfig;
       this.pathFiles = pathFiles;
    }
   
    public int getIdConfig() {
        return this.idConfig;
    }
    
    public void setIdConfig(int idConfig) {
        this.idConfig = idConfig;
    }
    public String getPathFiles() {
        return this.pathFiles;
    }
    
    public void setPathFiles(String pathFiles) {
        this.pathFiles = pathFiles;
    }




}


