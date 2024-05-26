package Alke_Wallet_Modulo5;

public class Cliente {
    private String nombre;
    private String apellido;
    private String correo_electronico;
    private String contrasena;

    // Constructor con todos los atributos
    public Cliente(String nombre, String apellido, String correo_electronico, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
    }

    // Constructor para autenticación
    public Cliente(String correo_electornico, String contrasena) {
        this.nombre = ""; 
        this.apellido = "";
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
    }

    // Constructor vacío
    public Cliente() {
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correo_electronico;
    }

    public void setCorreoElectronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

