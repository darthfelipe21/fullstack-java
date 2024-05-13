package Alke_Wallet_Modulo4;


// Crear las variables del objeto 
public class Cliente {
	private String nombre;
	private String apellido;
	private String rut;
	private String contrasena;
	
	// Crear el constructor de las variables
	public Cliente(String nombre, String apellido, String rut, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.contrasena = contrasena;
	}
	
	// Creación del constructor vacio para poder crear la instancia sin asignar valores
	public Cliente() {
		super();
	}
	
	// Creación de Getters y Setters para cada variable
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

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	
}
