package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Arquivo;

public class FileDao {

    Statement stmt;

    public FileDao() throws Exception, SQLException {

        stmt = ConnectMySQL.startConnection().createStatement();

    }

    public void insert(Arquivo file) throws Exception, SQLException {

        String sql = "INSERT INTO lm_file (name, extension, file_name) VALUES (?,?,?)";

        PreparedStatement pst = ConnectMySQL.startConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, file.getName());
        pst.setString(2, file.getExtension());
        pst.setString(3, file.getFileName());
        
        //System.out.println( "ok" + file.getFileName() );

        pst.execute();

    }

    public void delete(int id) throws Exception, SQLException {
        
        ResultSet rs;

        // SQL que retorna o último ID
        String sql = "DELETE FROM lm_file WHERE id_file=?;";

        PreparedStatement pst = ConnectMySQL.startConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, id);

        pst.execute();
        
    }
    
    public int getTheLastIDFile() throws Exception, SQLException {
        
        int file_id = 0;
        ResultSet rs;

        // SQL que retorna o último ID
        String sql = "SELECT id_file FROM lm_file ORDER BY id_file DESC LIMIT 1;";

        // Consulta no banco
        rs = stmt.executeQuery( sql );

        // Gera o valor do próximo ID
        while (rs.next()) {
            file_id = rs.getInt(1) + 1;
        }

        return file_id;
    }

    public ArrayList<Arquivo> getAllFiles() throws Exception, SQLException {
        
        ResultSet rs;
        Arquivo file;
        int file_id = 0;
        String file_ext;
        String file_name;
        ArrayList<Arquivo> files = new ArrayList();

        // SQL que retorna o último ID
        String sql = "SELECT * FROM lm_file;";

        // Consulta no banco
        rs = stmt.executeQuery( sql );

        // Gera uma lista de arquivos
        while (rs.next()) {
            
            file_id = rs.getInt(1);
            file_name = rs.getString(2);
            file_ext = rs.getString(3);
            file_name = rs.getString(4);
            
            file = new Arquivo(file_id, file_name, file_ext, file_name);
            
            files.add(file);
            
        }
        
        return files;       
        
    }
    
}
