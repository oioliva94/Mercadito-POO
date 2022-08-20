/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unah.edu.mercadito;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author migsauceda
 */
public class Conexion {
    public static Connection Conectar(){
        Connection cn;
        cn = null;
        
        String passwd= "elie1212";
        String usuario= "postgres";
        String BaseDatos= "Mercadito";
        String IP= "localhost";
        String Puerto= "5432";
        String url= "jdbc:postgresql://"+IP+":"+Puerto+"/"+BaseDatos;
        
        try{
            cn = DriverManager.getConnection(url,usuario,passwd);
        }catch(SQLException e){
            System.out.println("Error al conectarse a la base de datos");
        }
        return cn;
    }
}
