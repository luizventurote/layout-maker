package model;
// Generated Jun 7, 2014 1:29:31 AM by Hibernate Tools 3.6.0


import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Arquivo generated by hbm2java
 */
public class Arquivo  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String extension;
     private String directory;
     private Set componentes = new HashSet(0);
     
     /**
     * File source
     */
    private File file;

    public Arquivo() {
    }

	
    public Arquivo(String name, String extension, String directory) {
        this.name = name;
        this.extension = extension;
        this.directory = directory;
    }
    public Arquivo(String name, String extension, String directory, Set componentes) {
       this.name = name;
       this.extension = extension;
       this.directory = directory;
       this.componentes = componentes;
    }
    
    /**
     * Custom constructor
     */
    public Arquivo(int id, String name, String ext, String dir) {
        this.id = id;
        this.name = name;
        this.extension = ext;
        this.directory = dir;
    }

   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getExtension() {
        return this.extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
    public String getDirectory() {
        return this.directory;
    }
    
    public void setDirectory(String directory) {
        this.directory = directory;
    }
    public Set getComponentes() {
        return this.componentes;
    }
    
    public void setComponentes(Set componentes) {
        this.componentes = componentes;
    }

    public void generateDirectory() {
        this.directory = this.id + "_" + this.name.replaceAll(" ", "_").toLowerCase()+'.'+this.extension;
    }

}


