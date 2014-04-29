package model;

public class Arquivo {

    private int id;
    private String nome;
    private String extensao;

    public Arquivo(int id, String nome_base, String extensao) {
        this.id = id;
        this.extensao = extensao;

        // Monta o nome do arquivo
        this.nome = Integer.toString(id) + '_' + nome_base + '.' + extensao;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
