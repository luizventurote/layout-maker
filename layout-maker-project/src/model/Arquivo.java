package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Arquivo {
    
    private int id;
    private String nome;
    private String extensao;

    public Arquivo(int id, String nome_base, String extensao) {
        this.id = id;
        this.extensao = extensao;
        
        // Monta o nome do arquivo
        this.nome = Integer.toString(id)+'_'+nome_base+'.'+extensao;
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
    
    
     public static void copyFile(File source, File destination) throws IOException {  
     if (destination.exists())  
         destination.delete();  
  
     FileChannel sourceChannel = null;  
     FileChannel destinationChannel = null;  
  
     try {  
         sourceChannel = new FileInputStream(source).getChannel();  
         destinationChannel = new FileOutputStream(destination).getChannel();  
         sourceChannel.transferTo(0, sourceChannel.size(),  
                 destinationChannel);  
     } finally {  
         if (sourceChannel != null && sourceChannel.isOpen())  
             sourceChannel.close();  
         if (destinationChannel != null && destinationChannel.isOpen())  
             destinationChannel.close();  
    }  
}  
    
}
