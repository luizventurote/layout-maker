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

        String sql = "INSERT INTO lm_file (name, extension) VALUES (?,?)";

        PreparedStatement pst = ConnectMySQL.startConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, file.getName());
        pst.setString(2, file.getExtension());

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

}
