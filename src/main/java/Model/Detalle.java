/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Rekuta
 */
public class Detalle {
    private int numeroDetalle;
    private int numeroFactura;
    private int idProducto;
    private int Cantidad;
    
    public Detalle(){}
    public Detalle(int numeroDetalle, int numeroFactura, int idProducto, int Cantidad) {
        this.numeroDetalle = numeroDetalle;
        this.numeroFactura = numeroFactura;
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
    }

    public int getNumeroDetalle() {
        return numeroDetalle;
    }

    public void setNumeroDetalle(int numeroDetalle) {
        this.numeroDetalle = numeroDetalle;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    
}
