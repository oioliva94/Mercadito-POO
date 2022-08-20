/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author rekuta
 */

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoView {
    private ResultSetMetaData rsmt;
    
    public void imprimirDatosProducto(int idProducto, String nombreProducto, String descripcion,float precio){
        System.out.println("Codigo: "+idProducto);
        System.out.println("Nombre: "+nombreProducto);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Precio: "+precio);
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
            Logger.getLogger(ProductoView.class.getName()).log(Level.SEVERE, null, ex);
        }                   
    }
}
