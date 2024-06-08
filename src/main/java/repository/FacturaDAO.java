package repository;

import interfaces.MetodosGenerico;
import models.Factura;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacturaDAO implements MetodosGenerico<Factura> {

    @Override
    public ArrayList<Factura> listar() {
        ArrayList<Factura> facturas = null;
        try{
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM factura";
            PreparedStatement sentencia = con.prepareStatement(query);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()){
                Factura factura = new Factura();
                factura.setIdCliente(resultado.getInt("idCliente"));
                factura.setIdProducto(resultado.getInt("idProducto"));
                factura.setCantidad(resultado.getInt("cantidad"));
                factura.setFecha(resultado.getDate("fecha").toLocalDate());
                factura.setTotal(resultado.getFloat("total"));

                facturas.add(factura);
            }
            sentencia.close();
            resultado.close();
            return facturas;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Factura crear(Factura factura) {
        try{
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO factura (idCliente, idProducto, fecha, cantidad, total) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement sentencia = con.prepareStatement(query);
            sentencia.setInt(1, factura.getIdCliente());
            sentencia.setInt(2, factura.getIdProducto());
            sentencia.setDate(3, Date.valueOf(factura.getFecha()));
            sentencia.setInt(4, factura.getCantidad());
            sentencia.setFloat(5, factura.getTotal());

            sentencia.executeUpdate();
            sentencia.close();
            con.close();
            return factura;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
