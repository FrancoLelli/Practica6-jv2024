package models;

public class Producto {
    protected String nombreProducto;
    protected int stock;
    protected float precio;

    public Producto(){
        this.nombreProducto = "";
        this.precio = 0;
        this.stock = 0;
    }

    public Producto(String nombreProducto, int stock, float precio) {
        this.nombreProducto = nombreProducto;
        this.stock = stock;
        this.precio = precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                '}';
    }
}
