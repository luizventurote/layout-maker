package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Arquivo;

public class DefaultDao {
    
    Statement stmt;

    public DefaultDao() throws Exception, SQLException {
        
        this.stmt = ConnectMySQL.startConnection().createStatement();
        
    }
    
    /**
     * Get default file directory
     * 
     * @return String
     * @throws Exception
     * @throws SQLException 
     */
    public String getFilePath() throws Exception, SQLException {
        
        ResultSet rs;
        String path_files = "";

        // SQL que retorna o último ID
        String sql = "SELECT * FROM config LIMIT 1;";
        
        // Consulta no banco
        rs = this.stmt.executeQuery(sql);

        // Create new file
        while (rs.next()) {
            path_files = rs.getString(2);            
        }
        
        return path_files;
    }
    
}
