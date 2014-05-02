package model;

public class Framework {
    
    private int id;
    private String nome;
    
    public Framework(String nome) {
        this.nome = nome;
    }

    public Framework(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
  
}
