/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection_DB {
    private static String URL = "jdbc:mysql://localhost:3306/bd_sistemaABC_Hash";
    private static String User = "root";
    private static String Password = "123456789";

    public static Connection conectar() {
         Connection conexion = null;
         try{
             Class.forName("com.mysql.jdbc.Driver");
             conexion = DriverManager.getConnection(URL, User, Password);
             System.out.println("Conexion establecida");
         } catch (ClassNotFoundException | SQLException e) {
             System.out.println("Error de conexion: " + e);
         }
         return conexion;
    }
}
