package repository;

import interfaces.MetodosGenerico;
import models.Cliente;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO implements MetodosGenerico<Cliente> {
    public ArrayList<Cliente> listar(){
        ArrayList<Cliente> clientes = null;
        try{
            Connection con = Conexion.getConexion();
            if(con != null){
                String query = "SELECT * FROM cliente";
                PreparedStatement sentencia = con.prepareStatement(query);
                ResultSet datosClientes = sentencia.executeQuery();
                while (datosClientes.next()){
                    Cliente cliente = new Cliente();
                    cliente.setDni(datosClientes.getInt("dni"));
                    cliente.setNombreCliente(datosClientes.getString("nombreCliente"));
                    cliente.setEmail(datosClientes.getString("email"));
                    cliente.setTelefono(datosClientes.getString("telefono"));
                    clientes.add(cliente);
                };
                datosClientes.close();
                sentencia.close();

                return clientes;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Cliente crear(Cliente cliente) {
        try{
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO cliente (dni, nombreCliente, email, telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement sentencia = con.prepareStatement(query);
            sentencia.setInt(1,cliente.getDni());
            sentencia.setString(2,cliente.getNombreCliente());
            sentencia.setString(3,cliente.getEmail());
            sentencia.setString(4,cliente.getTelefono());
            sentencia.executeUpdate();
            sentencia.close();
            return cliente;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
