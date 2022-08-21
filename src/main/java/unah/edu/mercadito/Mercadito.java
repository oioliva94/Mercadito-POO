/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package unah.edu.mercadito;

import java.util.Scanner;
import Model.Cliente;

/**
 *
 * @author rekuta
 */
import Controller.ClienteController;
import Controller.ProductoController;
import Model.Producto;
import View.ClienteView;
import View.ProductoView;
public class Mercadito {

    public static void main(String[] args) {
        ProductoView vistaP=new ProductoView();
        Producto producto=new Producto();
        ProductoController controlP=new ProductoController(producto, vistaP);
        ClienteView vista=new ClienteView();
        Cliente cliente=InsertNOpersistente();
        ClienteController controlC=new ClienteController(cliente,vista);
       controlC.ActualizarVista();
       controlC.setId(12345);
       controlC.setNombreCliente("Mauro");
       controlC.setApellido("Torres");
       controlC.insertar();
       
      /* controlP.ActualizarVista();
       controlP.setIdProducto(8793);
       controlP.setNombreProducto("Mirinda");
       controlP.setDescripcion("refresco 1.5lts");
       controlP.setPrecio(24);
       controlP.Insertar();*/
        /*String continuar="s";
        int seleccion;
        Menu menu=new Menu();
        Scanner leer=new Scanner(System.in);
      do{                               //siclo para menu recurrente
          menu.menuPrincipal();
          seleccion=leer.nextInt();
        switch(seleccion){
            case 1: menu.menuProducto();
                    leer.nextLine();
                    seleccion=leer.nextInt();
                    switch(seleccion){
                        
                    }
                    break;
            case 2: menu.menuCliente();
                    leer.nextLine();
                    seleccion=leer.nextInt();
                    switch(seleccion){
                    
                    }
                    break;
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: continuar ="n";
                    break;
        }
       
      }
      while(continuar=="s"||continuar=="S");*/
    }
    
     public static Cliente InsertNOpersistente(){
        Cliente oCliente= new Cliente();
        oCliente.setIdCliente(12345);
        oCliente.setNombreCliente("Nombre codigo 123");
        oCliente.setApellido("Maradiaga");
        
        return oCliente;
    }
     
     public static Producto InsertNOpersistente2(){
        Producto oProducto= new Producto();
        oProducto.setIdProducto(46598);
        oProducto.setNombreProducto("zombos");
        oProducto.setDescripcion("chips de platano");
         oProducto.setPrecio(6);
        
        return oProducto;
    }
}
