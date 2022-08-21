/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author rekuta
 */
import Model.Producto;
import View.ProductoView;
import unah.edu.mercadito.Conexion;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ProductoController {
    
    private Producto modelo;
    private ProductoView vista;
    
    private Connection cn;
    private boolean exito;
    private Statement st;
    private ResultSet rs;
    private String sql;
    
    public ProductoController(){}

    public ProductoController(Producto modelo, ProductoView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public int getIdProducto(){
        return this.modelo.getIdProducto();
    }
    
    public void setIdProducto(int id){
        this.modelo.setIdProducto(id);
    }
    
    public String getNombreProducto(){
        return this.modelo.getNombreProducto();
    }
    
    public void setNombreProducto(String nombre){
        this.modelo.setNombreProducto(nombre);
    }
    
    public String getDescripcion(){
        return this.modelo.getDescripcion();
    }
    
    public void setDescripcion(String descripcion){
        this.modelo.setDescripcion(descripcion);
    }
    
    public float getPrecio(){
        return this.modelo.getPrecio();
    }
    
    public void setPrecio(float precio){
        this.modelo.setPrecio(precio);
    }
    
    public int getStok(){
        return modelo.getStok();
    }
    
    public void setStok(int stok){
        this.modelo.setStok(stok);
    }
    
     public void ActualizarVista(){
       vista.imprimirDatosProducto(modelo.getIdProducto(),modelo.getNombreProducto(), modelo.getDescripcion(),modelo.getPrecio(),modelo.getStok());
    }
    
    public boolean Insertar( ){
        exito= false;
        st= null;
        cn= null;
                
        sql= "insert into Producto values ('"+
                modelo.getIdProducto()+"', '"+modelo.getNombreProducto()+"','"+modelo.getDescripcion()+"','"+modelo.getPrecio()+modelo.getStok()+"')";
        
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
        
        sql= "update Producto set nombre= '"+modelo.getNombreProducto()+"' "+
                "where id='"+modelo.getIdProducto()+"'";
        
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
        
        sql= "select idProducto, nombreProducto, descripcion, precio, stok from Producto where idProducto= '"+Id+"'";
        
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
