package model;

public class Arquivo {

    private int id;
    private String name;
    private String extension;

    public Arquivo(int id, String base_name, String extension) {
        this.id = id;
        this.extension = extension;

        // Set file name
        this.name = Integer.toString(id) + '_' + base_name + '.' + extension;
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

}
