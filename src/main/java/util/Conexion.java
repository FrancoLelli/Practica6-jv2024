package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static final String URL = "jdbc:mysql://localhost:3306/dietetica";
    static final String USER = "root";
    static final String PASS = "";

    public static Connection getConexion(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return con;
        }
    }
}
