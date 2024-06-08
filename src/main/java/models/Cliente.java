package models;

public class Cliente {
    protected int dni;
    protected String nombreCliente;
    protected String email;
    protected String telefono;

    public Cliente(){
        this.dni = 0;
        this.email = "";
        this.nombreCliente = "";
        this.telefono = "";
    }

    public Cliente(int dni, String nombreCliente, String email, String telefono) {
        this.dni = dni;
        this.nombreCliente = nombreCliente;
        this.email = email;
        this.telefono = telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
