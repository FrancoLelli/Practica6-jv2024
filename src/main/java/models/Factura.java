package models;

import java.time.LocalDate;

public class Factura {
    protected int idCliente;
    protected int idProducto;
    protected LocalDate fecha;
    protected int cantidad;
    protected float total;

    public Factura(){
        this.idCliente = 0;
        this.idProducto = 0;
        this.fecha = LocalDate.parse("");
        this.cantidad = 0;
        this.total = 0;
    }

    public Factura(int idCliente, int idProducto, LocalDate fecha, int cantidad, float total) {;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.total = total;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idCliente=" + idCliente +
                ", idProducto=" + idProducto +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", total=" + total +
                '}';
    }
}
