package model;

import java.io.File;

public class Arquivo {

    private int id;
    private String name;
    private String extension;
    private String file_name;
    private File file;

    public Arquivo(int id, String base_name, String extension, File file) {
        this.id = id;
        this.extension = extension;

        // Set file name
        this.name = Integer.toString(id) + '_' + base_name + '.' + extension;
    }
    
    public Arquivo(String base_name, File file) {
        this.extension = extension;

        // Set file name
        this.name = Integer.toString(id) + '_' + base_name + '.' + extension;
    }
    
    public Arquivo(int id, String name, String ext, String file_name) {
        this.id = id;
        this.name = name;
        this.extension = ext;
        this.file_name = file_name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getFileName() {
        return file_name;
    }

    public void setFileName(String file_name) {
        this.file_name = file_name;
    }

}
