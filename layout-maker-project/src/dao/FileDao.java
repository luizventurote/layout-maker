package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.Arquivo;

public class FileDao {
    
    Statement stmt;

    public FileDao() throws Exception, SQLException {
        
        stmt = ConnectMySQL.startConnection().createStatement();
        
    }
    
    public void inserir ( Arquivo file ) throws Exception, SQLException {
   
        String sql = "INSERT INTO lm_file (name, extension) VALUES (?,?)";
        
        PreparedStatement pst = ConnectMySQL.startConnection().prepareStatement( sql, PreparedStatement.RETURN_GENERATED_KEYS ) ;
        pst.setString(1, file.getName() );
        pst.setString(2, file.getExtension());
        
        pst.execute();
                  
    }
}
