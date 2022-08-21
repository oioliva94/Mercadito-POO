/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author rekuta
 */

import Model.Cliente;
import Model.Producto;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
public class FacturaView {
       private ResultSetMetaData rsmt;
    
    public void ImprimirDatosFactura(int numeroFactura, LocalDate fecha,Cliente cliente){
        System.out.println("Factura #: " + numeroFactura);
        System.out.println("fecha: " + fecha);
        System.out.println("Cliente#: " + cliente.getIdCliente());
    
    } 
    public void ImprimirDatosDetalle(int numeroDetalle, Producto producto,int cantidad){
          System.out.println(numeroDetalle+"  "+producto.getNombreProducto()+" "+
                            producto.getPrecio()+" "+cantidad);
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
