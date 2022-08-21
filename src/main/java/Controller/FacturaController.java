/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author rekuta
 */

import Model.Factura;
import View.FacturaView;
import unah.edu.mercadito.Conexion;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;




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
    public FacturaController(Factura modelo, FacturaView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    //encapsulamiento
    public int getNumeroFactura(){
       return this.modelo.getNumeroFactura();
    }
    
    public void setNumeroFactura(int id){
        this.modelo.setNumeroFactura(id);
    }
    
    public int getIdCliente(){
        return this.modelo.getIdCliente();
    }
    
    public void setIdCliente(int idCliente){
        this.modelo.setIdCliente(idCliente);
    }
    
    public LocalDate getFecha(){
        return this.modelo.getFecha();
    }
    
    public void setFecha(LocalDate fecha){
        this.modelo.setFecha(fecha);
    }
    //metodos
    public void ActualizarVista(){
        vista.imprimirDatosFactura(this.modelo.getNumeroFactura(),this.modelo.getIdCliente(), this.modelo.getFecha());
    }
    
     public boolean Insertar( ){//inserta factura
        exito= false;
        st= null;
        cn= null;
                
        sql= "insert into Factura values ("+modelo.getNumeroFactura()+", "+modelo.getFecha()+","+modelo.getIdCliente()+");";
        
        try{
            cn= Conexion.Conectar();
            st= cn.createStatement();
            st.execute(sql);
            
            exito= true;
            
            st.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al insert en BD");
        }
        return exito;
    }
   
     public boolean Select(int Id){
        exito= false;
        st= null;
        cn= null;
        
        sql= "select numeroFactura, idCliente, fechafrom Factura where numeroFactura= "+Id;
        
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
    
      public boolean SelectAll(){
        exito= false;
        st= null;
        cn= null;
        
       sql= "select numeroFactura, idCliente, fechafrom Factura";
        
        try{
            cn= Conexion.Conectar();
            st= cn.createStatement();
            rs= st.executeQuery(sql);
        
            vista.ImprimirSelect(rs);
       
            
            exito= true;
        } catch(SQLException e){
            System.out.println("Error en la ejecucion select all");
        }
        return exito;
    }
}
