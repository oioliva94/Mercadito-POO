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
import Controller.*;
import Model.*;
import View.*;
import java.time.LocalDate;
public class Mercadito {

    public static void main(String[] args) {
        boolean salir; 
        String fin;
       Producto producto=new Producto();
       ProductoView vistaProd=new ProductoView();
       ProductoController controlP=new ProductoController(producto,vistaProd);
       
       Cliente cliente=new Cliente();
       ClienteView vistaCliente=new ClienteView();
       ClienteController controlC=new ClienteController(cliente,vistaCliente);
       
       Factura factura=new Factura();
       FacturaView vistaFac=new FacturaView();
       FacturaController controlF=new FacturaController(factura,vistaFac);
       
       Detalle detalle=new Detalle();
       DetalleView vistaDetalle=new DetalleView();
       DetalleController controlD=new DetalleController(detalle,vistaDetalle);
        String continuar="s";
        int seleccion;
        Menu menu=new Menu();
        Scanner leer=new Scanner(System.in);
        
        //interfas de prueba
      do{                               //siclo para menu recurrente
          menu.menuPrincipal();
          seleccion=leer.nextInt();
        switch(seleccion){
            case 1: do{
                menu.menuProducto();// gestion de producto
                    leer.nextLine();
                    seleccion=leer.nextInt();
                    switch(seleccion){
                        case 0: continuar="n";
                        case 1: controlP.SelectAll();//ver productos
                                break;
                            
                        case 2:
                            leer.nextLine();// agregar producto
                            System.out.println("Ingrese id del producto");
                            controlP.setIdProducto(leer.nextInt());  leer.nextLine();
                            System.out.println("Ingrese nombre del producto");
                            controlP.setNombreProducto(leer.next());  leer.nextLine();
                            System.out.println("Ingrese descripcion del producto");
                            controlP.setDescripcion(leer.next());  leer.nextLine();
                            System.out.println("Ingrese precio del producto");
                            controlP.setPrecio(leer.nextFloat());  leer.nextLine();
                            System.out.println("Ingrese cantidad del producto");
                            controlP.setStok(leer.nextInt());  leer.nextLine();
                            controlP.Insertar();
                            controlP.ActualizarVista();
                            break;
                            
                        case 3://modificar precio de producto
                                controlP.SelectAll();
                             System.out.println("Ingrese id del producto a modificar");
                             int id=leer.nextInt(); leer.nextLine();
                             System.out.println("Ingrese el nuevo precio");
                             controlP.setPrecio(leer.nextInt()); leer.nextLine();
                             controlP.Update(id);
                             break;
                        case 4: //eliminar producto
                                leer.nextLine();
                                controlP.SelectAll();
                             System.out.println("Ingrese id del producto a eliminar");
                             if(controlP.Eliminar(leer.nextInt()))
                                  System.out.println("producto eliminado");
                             else
                                  System.out.println("error al borrar producto");
                             
                             break;
                    }
            }while("s".equals(continuar)||"S".equals(continuar));
            continuar="s";
                    break;
            case 2:do{
                    menu.menuCliente();
                    leer.nextLine();
                    seleccion=leer.nextInt();
                    switch(seleccion){
                     case 0: continuar="n";
                        case 1: controlC.SelectAll();//ver clientes
                                break;
                            
                        case 2:
                            leer.nextLine();// agregar clientes
                            System.out.println("Ingrese id del cliente");
                            controlC.setId(leer.nextInt());  leer.nextLine();
                            System.out.println("Ingrese nombre del cliente");
                            controlC.setNombreCliente(leer.next());  leer.nextLine();
                            System.out.println("Ingrese apellido del Cliente");
                            controlC.setApellido(leer.next());  leer.nextLine();
                            controlC.insertar();
                            controlC.ActualizarVista();
                            break;
                            
                        case 3://modificar nombre de cliente
                                controlC.SelectAll();
                             System.out.println("Ingrese id del producto a modificar");
                             int id=leer.nextInt(); leer.nextLine();
                             System.out.println("Ingrese el nuevo precio");
                             controlC.setNombreCliente(leer.next()); leer.nextLine(); 
                             System.out.println("Ingrese el nuevo precio");
                             controlC.setApellido(leer.next()); leer.nextLine();
                             controlP.Update(id);
                             break;
                        case 4: //eliminar cliente
                                leer.nextLine();
                                controlC.SelectAll();
                             System.out.println("Ingrese id del cliente a eliminar");
                             if(controlC.Eliminar(leer.nextInt()))
                                  System.out.println("Cliente eliminado");
                             else
                                  System.out.println("error al borrar cliente");
                             
                             break;
                    }
                    }while("s".equals(continuar)||"S".equals(continuar));
            continuar="s";
                    break;
            case 3:
                do{//Facturacion
                            salir=false;
                            fin="b";
                            System.out.println("ingrese el codigo de Factura");
                            int numFactura=leer.nextInt();leer.nextLine();
                           System.out.println("ingrese el codigo de cliente");
                            int client=leer.nextInt();
                            controlF.setIdCliente(client); leer.nextLine();
                            System.out.println("ingrese el codigo de detalle");
                            int numDetalle=leer.nextInt();leer.nextLine();
                            controlF.setFecha(LocalDate.now());
                            controlF.Insertar();
                            controlD.setNumeroFactura(numFactura);
                            controlD.setNumeroDetalle(numDetalle);
                        while(salir!=true){
                            
                            
                            System.out.println("ingrese el codigo del producto");
                            controlD.setIdProducto(leer.nextInt()); leer.nextLine();
                            System.out.println("ingrese la cantidad de producto");
                            controlD.setCantidad(leer.nextInt()); leer.nextLine();
                            controlD.insertar();
                            System.out.println("Presione 'T' para finalizr escaneo");
                            fin=leer.next();
                            if("t".equals(fin)||"T".equals(fin)){
                               salir=true;
                            }
                        }
                       
                        controlF.Select(numFactura);
                        controlD.Select(numDetalle);
                        
                        System.out.println("Total"+controlD.totalDetalle(numDetalle)+"\n\n\n\n\n /////////////////////////////////////////////////////// \n\n\n\n\n");
                        System.out.println("Presione 'S' para continuar. \n Presione cualquir tecla para finalizar");
                        continuar=leer.next();
                    }while("s".equals(continuar)||"S".equals(continuar));
            continuar="s"; break;
            case 4: controlD.detalleCierre(LocalDate.now());
                    System.out.println("Total del dia: "+controlD.cierreCajaTotal(LocalDate.now()));
                    break;
            case 5: break;
            case 0: continuar ="n";
                    break;
        }
       
      }
      while("s".equals(continuar)||"S".equals(continuar));
    }
    
 
}
