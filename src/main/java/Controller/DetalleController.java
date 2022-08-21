/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Detalle;
import View.DetalleView;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import unah.edu.mercadito.Conexion;

/**
 *
 * @author Rekuta
 */
public class DetalleController {
    Detalle modelo;
    DetalleView vista;
    
    private Connection cn;
    private boolean exito;
    private Statement st;
    private ResultSet rs;
    private String sql;
    
    public DetalleController(){}
    public DetalleController(Detalle modelo, DetalleView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public int getNumeroDetalle(){
        return this.modelo.getNumeroDetalle();
    }
    
    public void setNumeroDetalle(int id){
        this.modelo.setNumeroDetalle(id);
    }
    
    public int getNumeroFactura(){
        return this.modelo.getNumeroFactura();
    }
    
    public void setNumeroFactura(int id){
        this.modelo.setNumeroFactura(id);
    }
    
    public int getIdProducto(){
        return this.modelo.getIdProducto();
    }
    
    public void setIdProducto(int id){
        this.modelo.setIdProducto(id);
    }
    
    public int getCantidad(){
        return this.modelo.getCantidad();
    }
    
    public void setCantidad(int cantidad){
         this.modelo.setCantidad(cantidad);
    }
    
    //metodos
    public void ActualizarVista(){
       vista.imprimirDatosDetalle(modelo.getNumeroDetalle(),modelo.getNumeroFactura(), modelo.getIdProducto(),modelo.getCantidad());
    }
    
 
    public boolean insertar() {
         exito= false;
        st= null;
        cn= null;
                
        sql= "insert into Detalle values ("+modelo.getNumeroDetalle()+", "+modelo.getNumeroFactura()+","+modelo.getIdProducto()+modelo.getCantidad()+")";
        
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
        
        sql= "update Detalle set cantidad= '"+modelo.getCantidad()+
                "where numeroDetalle="+Id;
              
        
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
        
        sql= "select p.nombreproducto ,p.precio ,cantidad from Detalle d" +
            "inner join producto p on d.numeroDetalle=p.idproducto where numeroDetalle="+Id+";";
        
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
        
       sql= "select p.nombreproducto ,p.precio ,cantidad from Detalle d" +
            "inner join producto p on d.numeroDetalle=p.idproducto;";
        
        try{
            cn= Conexion.Conectar();
            st= cn.createStatement();
            rs= st.executeQuery(sql);
        
            vista.ImprimirSelect(rs);
       
            
            exito= true;
            
            st.close();
            cn.close();
        } catch(SQLException e){
            System.out.println("Error en la ejecucion select");
        }
        return exito;
    }
      
      public double totalDetalle(int Id){
         double total=0;
        st= null;
        cn= null;
        
        sql= "select p.nombreproducto ,p.precio ,cantidad from Detalle d" +
            "inner join producto p on d.numeroDetalle=p.idproducto where numeroDetalle="+Id+";";
        
        try{
            cn= Conexion.Conectar();
            st= cn.createStatement();
            rs= st.executeQuery(sql);
            
            while(rs.next()){
                total=total+(rs.getDouble("precio")*rs.getInt("cantidad"));
            }
            
            
            st.close();
            cn.close();
        } catch(SQLException e){
            System.out.println("Error en la ejecucion select");
        }
        return total;
      }
      
      public double cierreCajaTotal(LocalDate fecha){
         double total=0;
        st= null;
        cn= null;
        fecha=LocalDate.now();
        sql= "select p.nombreproducto ,p.precio ,cantidad from Detalle d" +
            "inner join producto p on d.numeroDetalle=p.idproducto where fecha="+fecha+";";
        
        try{
            cn= Conexion.Conectar();
            st= cn.createStatement();
            rs= st.executeQuery(sql);
            
            while(rs.next()){
                total=total+(rs.getDouble("precio")*rs.getInt("cantidad"));
            }
            
            
            st.close();
            cn.close();
        } catch(SQLException e){
            System.out.println("Error en la ejecucion select");
        }
        return total;
      }
      
      public boolean detalleCierre(LocalDate fecha){
        exito= false;
        st= null;
        cn= null;
        fecha=LocalDate.now();
        sql= "select p.nombreproducto ,p.precio ,cantidad from Detalle d" +
            "inner join producto p on d.numeroDetalle=p.idproducto where numeroDetalle="+fecha+";";
        
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
