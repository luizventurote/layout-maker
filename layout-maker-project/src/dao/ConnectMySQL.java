package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {
    
    static Connection db_connect;
    static String server = "127.0.0.1";  // localhost
    static String database = "layout_maker";
    static String login = "root";
    static String pass = "";
    
    static Connection startConnection() throws Exception, SQLException {
        
        String url = "jdbc:mysql://" + server + "/" + database ;
        
        Class.forName("com.mysql.jdbc.Driver");
        db_connect = DriverManager.getConnection(url, login, pass);
        return db_connect;                
    }
}
