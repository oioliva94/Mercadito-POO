/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unah.edu.mercadito;

/**
 *
 * @author rekuta
 */
public class Menu {
    public Menu(){}
    public void menuPrincipal(){
    System.out.println("Bienvenido a Mercadito POO\n"+
                  "Seleccione una de se las siguientes opciones para continuar:");
          
    System.out.println("1. Gestionar productos");
    System.out.println("2. Gestionar Clientes");
    System.out.println("3. Facturar");
    System.out.println("4. Cierre de caja");
    System.out.println("5. Auditoria");
    System.out.println("6. Salir");
    }
    
    public void menuCliente(){
        System.out.println("1. Consultar clientes frecuentes");
        System.out.println("2. Agregar a Clientes frecuentes");
        System.out.println("3. Modificar datos de cliente");
        System.out.println("4. Eliminar cliente");
        System.out.println("0. Salir");
    }
    
    public void menuProducto(){
        System.out.println("1. Consultar Prodcutos");
        System.out.println("2. Agregar Prodcutos a base de datos");
        System.out.println("3. Modificar datos de producto");
        System.out.println("4. Eliminar producto");
        System.out.println("0. Salir");
    }
           
}
