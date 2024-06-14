/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author eswinpineda
 */
public class Metodos_SQL {
    
    private static Connection conexion;
    private static PreparedStatement sentencia_preparada;
    private static ResultSet resultado;
    
    
    public static String buscarUserLogin(String user, String password)
    {
        String mensaje = null;
        try {
            conexion = Conection_DB.conectar();
            String consulta = "SELECT nombre_usuario, contrasenia_hash FROM usuarios WHERE nombre_usuario = ? AND contrasenia_hash = ?";
            sentencia_preparada =  conexion.prepareStatement(consulta);
            sentencia_preparada.setString(1, user);
            sentencia_preparada.setString(2, password);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){
                mensaje = "Correcto";
            }
            else{
                mensaje = "Incorrecto";
            }
            conexion.close();
        }   catch (SQLException e){
            System.out.println("Error: " + e);
        }
        finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Metodos_SQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                System.out.println("Error: " + ex);
            }
        }
        return mensaje;
    }

}
