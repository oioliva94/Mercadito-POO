/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.LocalDate;

/**
 *
 * @author rekuta
 */
public class Factura {
    //atributos
    private int numeroFactura;
    private LocalDate fecha;
    private int idCliente;
    
    //constructores
    public Factura(){}
    public Factura(int numeroFactura,int idCliente,LocalDate fecha) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.idCliente = idCliente;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha ) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
