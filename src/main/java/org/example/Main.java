package org.example;

import models.Cliente;
import models.Factura;
import models.Producto;

import repository.ClienteDAO;
import repository.FacturaDAO;
import repository.ProductoDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {

            System.out.println("1. Agregar producto");
            System.out.println("2. Ver productos");
            System.out.println("3. Agregar cliente");
            System.out.println("4. Ver clientes");
            System.out.println("5. Agregar Factura");
            System.out.println("6. Ver Facturaa");
            System.out.println("7. Salir");

            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    agregarCliente();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    agregarFactura();
                    break;
                case 6:
                    listarFacturas();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 7);
    }

    public static void agregarProducto() {
        scanner.nextLine();
        System.out.print("Nombre Producto: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Precio de venta: ");
        float precio = scanner.nextFloat();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        Producto producto = new Producto(nombreProducto, stock, precio);
        ProductoDAO productoDAO = new ProductoDAO();
        Producto productoAgregado = productoDAO.crear(producto);
        System.out.println("Producto agregado exitosamente: "+productoAgregado.toString());
    }

    public static void listarProductos(){
        System.out.print("Productos: ");
        ProductoDAO productoDAO = new ProductoDAO();
        ArrayList<Producto> productos = productoDAO.listar();
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
    }

    public static void agregarCliente(){
        scanner.nextLine();
        System.out.print("Nombre Cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("DNI: ");
        int dni = scanner.nextInt();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(dni, nombreCliente, email, telefono);
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente clienteCreado = clienteDAO.crear(cliente);
        System.out.println(clienteCreado.toString());
    }

    public static  void listarClientes(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.listar();
        for (Cliente cliente: clientes){
            System.out.println(cliente.toString());
        }
    }

    public static void agregarFactura(){
        scanner.nextLine();
        System.out.print("Id Cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Id Producto: ");
        int idProducto = scanner.nextInt();
        LocalDate fecha = LocalDate.now();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("Total: ");
        float total = scanner.nextFloat();

        Factura factura = new Factura(idCliente, idProducto, fecha, cantidad, total);
        FacturaDAO facturaDAO = new FacturaDAO();
        Factura facturaAgregada = facturaDAO.crear(factura);
        System.out.println(facturaAgregada.toString());
    }

    public static  void listarFacturas(){
        FacturaDAO facturaDAO = new FacturaDAO();
        ArrayList<Factura> facturas = facturaDAO.listar();
        for (Factura factura: facturas){
            System.out.println(factura.toString());
        }
    }

}
