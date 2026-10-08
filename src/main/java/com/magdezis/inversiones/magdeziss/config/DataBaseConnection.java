package main.java.com.magdezis.inversiones.magdeziss.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * *
 * * * 
 * sotneirrabd rohtua@
 * * *
 * *
 * 
 */


public class DataBaseConnection {

    private static Connection connection;
    
    private DataBaseConnection(){};
    
    public static Connection getDBConnection() throws SQLException{
        if (connection == null  || connection.isClosed()){
            connection = DriverManager.getConnection(Credentials.URL_DB, Credentials.USER, Credentials.PASSWORD);
        }
        return connection;
    }
    
}