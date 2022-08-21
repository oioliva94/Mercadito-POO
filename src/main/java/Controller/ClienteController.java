/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Cliente;
import View.ClienteView;
import unah.edu.mercadito.Conexion;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author rekuta
 */
public class ClienteController   {
    private Cliente modelo;
    private ClienteView vista;
    
    private Connection cn;
    private boolean exito;
    private Statement st;
    private ResultSet rs;
    private String sql;
   
    
    public ClienteController(){}
    public ClienteController(Cliente modelo, ClienteView vista ) {
        this.modelo = modelo;
        this.vista = vista;
        
    }
    
    public int getId(){
        return this.modelo.getIdCliente();
    }
    
    public void setId(int id){
        this.modelo.setIdCliente(id);
    }
    
    public String getNombreCliente(){
        return this.modelo.getNombreCliente();
    }
    
    public void setNombreCliente(String nombre){
        this.modelo.setNombreCliente(nombre);
    }
    
    public String getApellido(){
        return this.modelo.getApellido();
    }
    
    public void setApellido(String apellido){
        this.modelo.setApellido(apellido);
    }
    
    
    
    public void ActualizarVista(){
       vista.imprimirDatosClinete(modelo.getIdCliente(),modelo.getNombreCliente(), modelo.getApellido());
    }
    
 
    public boolean insertar() {
         exito= false;
        st= null;
        cn= null;
                
        sql= "insert into clientes values ('"+
                modelo.getIdCliente()+"', '"+modelo.getNombreCliente()+"','"+modelo.getApellido()+"')";
        
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
    
     
     public boolean Update(int Id){
        exito= false;
        st= null;
        cn= null;
        
        sql= "update clientes set nombre= '"+modelo.getNombreCliente()+"' "+
                "where id="+modelo.getIdCliente()+
                "update clientes set apellido= '"+modelo.getApellido()+"' "+
                "where id="+modelo.getIdCliente();
        
        try{
            cn= Conexion.Conectar();
            st= cn.createStatement();
            st.execute(sql);
            
            exito= true;
            
            st.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error en la ejecucion update");
        }
        return exito;        
    }
     
     public boolean Select(int Id){
        exito= false;
        st= null;
        cn= null;
        
        sql= "select idCliente, nombreCliente from persona where id= '"+Id+"'";
        
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
public boolean Eliminar(int id){
         exito= false;
        st= null;
        cn= null;
        
        sql= "delete from Clientes where idCliente= "+id;
        
        try{
            cn= Conexion.Conectar();
            st= cn.createStatement();
            st.execute(sql);
            
            exito= true;
            
            st.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error en la ejecucion delete");
        }
        return exito;      
     }
     
    
   
    
      public boolean SelectAll(){
        exito= false;
        st= null;
        cn= null;
        
        sql= "select idCliente, nombreCliente, apellido from Clientes";
        
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
