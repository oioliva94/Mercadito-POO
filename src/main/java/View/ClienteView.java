/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rekuta
 */
public class ClienteView {
    private ResultSetMetaData rsmt;
    
    public void imprimirDatosClinete(int id, String nombre, String apellido){
        System.out.println("Identidad: "+id);
        System.out.println("Nombre: "+nombre);
        System.out.println("Nombre: "+apellido);
    } 
    
    public void ImprimirSelect(ResultSet rs){
        try {
            rsmt= rs.getMetaData();
            
            int columnas= rsmt.getColumnCount();
            while (rs.next()){
                System.out.println("Datos:");
                for (int i= 1; i <= columnas; i++){
                    System.out.println("Columna "+i+": "+rs.getString(i));
                }
            }            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
        }                   
    }
}
