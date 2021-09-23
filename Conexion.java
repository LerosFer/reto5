
package com.mycompany.reto5;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    private Connection conn;
    private static final String Driver= "com.mysql.jdbc.Driver";
    private static final String user= "root";
    private static final String password= "";
    private static final String url= "jdbc:mysql://localhost:3306/reto5";
    public Conexion(){
        conn= null;
        try{
            Class.forName(Driver);
            conn= DriverManager.getConnection(url, user, password);
            if(conn!=null){
                System.out.println("Conexión exitosa");
            }
        }catch (Exception e){
            System.out.println("Error de conexión"+e);
        }
    }
public Connection getConexion(){
    return conn;
} 
}
