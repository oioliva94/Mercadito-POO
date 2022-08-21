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
 * @author Rekuta
 */
public class DetalleView {
     private ResultSetMetaData rsmt;
    
    public void imprimirDatosDetalle(int numeroDetalle, int numeroFactura,int idProducto, int cantidad){
        System.out.println("Detalle #: "+numeroDetalle);
        System.out.println("Factura: "+numeroFactura);
        System.out.println("Codigo producto: "+idProducto);
         System.out.println("cantidad: "+cantidad);
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
