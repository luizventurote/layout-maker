package model;
// Generated Jun 7, 2014 1:46:42 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Componente generated by hbm2java
 */
public class Componente  implements java.io.Serializable {


     private Integer id;
     private Categoria categoria;
     private String nome;
     private Set arquivos = new HashSet(0);

    public Componente() {
    }

	
    public Componente(Categoria categoria, String nome) {
        this.categoria = categoria;
        this.nome = nome;
    }
    public Componente(Categoria categoria, String nome, Set arquivos) {
       this.categoria = categoria;
       this.nome = nome;
       this.arquivos = arquivos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set getArquivos() {
        return this.arquivos;
    }
    
    public void setArquivos(Set arquivos) {
        this.arquivos = arquivos;
    }




}


