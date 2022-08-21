/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author rekuta
 */
import Model.Cliente;
import Model.Factura;
import Model.Producto;
import View.FacturaView;
import unah.edu.mercadito.Conexion;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;



public class FacturaController   {
    //atributos
    private Factura modelo;
    private FacturaView vista;
    //atributos de conexion
    private Connection cn;
    private boolean exito;
    private Statement st;
    private ResultSet rs;
    private String sql;

    //constructores
    public FacturaController(){}
    public FacturaController(Factura modelo, FacturaView vista){
        this.modelo=modelo;
        this.vista=vista;
    }
    //encapsulamiento
    public int getNumeroFactura(){
        return this.modelo.getNumeroFactura();
    }
    
    public void setNumeroFactura(int num){
        this.modelo.setNumeroFactura(num);
    }
    
    public LocalDate getFecha(){
        return this.modelo.getFecha();
    }
    
    public void setFecha(LocalDate fecha){
        this.modelo.setFecha(fecha);
    }
    
    public Cliente getCliente(){
        return this.modelo.getCliete();
    }
    
    public void setCliente(Cliente cliente){
        this.modelo.setCliete(cliente);
    }
    
    public Producto getProducto(){
        return this.modelo.getProducto();
    }
    
    public void setProducto(Producto producto){
        this.modelo.setProducto(producto);
    }
    
    public int getCantidad(){
        return modelo.getCantidad();
    }
    
    public void setCantidad(int cantidad){
        this.modelo.setCantidad(cantidad);
    }
    
    public int getNumeroDetalle(){
        return this.modelo.getNumeroDetalle();
    }
    
    public void setNumeroDetalle(int detalle){
        this.modelo.setNumeroDetalle(detalle);
    }

    //metodos 
   
    
    public boolean insertar() {//inserta datos de la factura
        exito=false;
        st=null;
        cn=null;
        sql="insert into Factura values("+modelo.getNumeroFactura()+","+modelo.getFecha()+","+modelo.getCliete().getIdCliente()+");"
            +"insert into Detalle values("+modelo.getNumeroDetalle()+","+modelo.getNumeroFactura()+","+modelo.getProducto().getIdProducto()+","+modelo.getCantidad()+");";
        try{
            cn=Conexion.Conectar();
            st=cn.createStatement();
            exito= true;
            st.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al insert en BD"); 
        }
        return exito;
    }
    
    
    public void ActualizarVista() {
        vista.ImprimirDatosFactura(modelo.getNumeroFactura(),modelo.getFecha(),modelo.getCliete());
        vista.ImprimirDatosDetalle(modelo.getNumeroDetalle(),modelo.getProducto(),modelo.getCantidad());
    }

    public boolean Select(int id) {
      exito= false;
        st= null;
        cn= null;
        
        sql= "select numeroFactura, c.idCliente, fecha from Factura f where numeroFactura="+id+
                "inner join clientes c" +
                "on f.idcliente=c.idcliente;"+
                "select numeroDetalle, d.idProducto,p.nombreproducto ,p.precio,cantidad from Detalle d  where numeroFactura="+id+
                "inner join producto p on d.numeroDetalle=p.idproducto;";
        
        try{
            cn= Conexion.Conectar();
            st= cn.createStatement();
            rs= st.executeQuery(sql);
            
            vista.ImprimirSelect(rs);
            
            exito= true;
        } catch(SQLException e){
            System.out.println("Error en la ejecucion select");
        }
        return exito;
    }
    
}
