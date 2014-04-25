package model;

import java.util.ArrayList;

public class Componente {
   
    private int id;
    private String nome;
    private float tempo;
    private float valor;
    private ArrayList<Arquivo> arquivos;

    public Componente(int id, String nome, float tempo, float valor) {
        this.id = id;
        this.nome = nome;
        this.tempo = tempo;
        this.valor = valor;
    }

    public ArrayList<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(ArrayList<Arquivo> arquivos) {
        this.arquivos = arquivos;
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

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
