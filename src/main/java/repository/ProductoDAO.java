package repository;

import interfaces.MetodosGenerico;
import models.Producto;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO implements MetodosGenerico<Producto> {
    @Override
    public ArrayList<Producto> listar() {
        ArrayList<Producto> productos = new ArrayList<>();
        try{
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM producto";
            PreparedStatement sentencia = con.prepareStatement(query);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                Producto producto = new Producto();
                producto.setNombreProducto(resultado.getString("nombreProducto"));
                producto.setPrecio(resultado.getFloat("precio"));
                producto.setStock(resultado.getInt("stock"));

                productos.add(producto);
            }
            sentencia.close();
            resultado.close();
            con.close();
            return productos;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Producto crear(Producto producto) {
        try{
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO producto (nombreProducto, stock, precio) VALUES (?, ?, ?)";
            PreparedStatement setencia = con.prepareStatement(query);
            setencia.setString(1, producto.getNombreProducto());
            setencia.setInt(2, producto.getStock());
            setencia.setFloat(3, producto.getPrecio());
            setencia.executeUpdate();
            setencia.close();
            con.close();
            return producto;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
