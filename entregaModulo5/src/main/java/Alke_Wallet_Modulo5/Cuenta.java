package Alke_Wallet_Modulo5;

/* A la clase cuenta se la hace la implementación de la interface DepositoRetiro, se hace un llamado
 * a la clase Cliente, ya que no existe cuenta sin cliente
 * */
public class Cuenta implements DepositoRetiro {
    private Cliente cliente;
    private double saldo;
    
    // Creación de la variables de la pertenicientes a esta clase instanciando a la clase cliente
    public Cuenta(Cliente cliente, double saldo) {
		super();
		this.cliente = cliente;
		this.saldo = saldo;
	}
    
    // Creación del constructor vacio para poder crear la instancia sin asignar valores
	public Cuenta() {
		super();
	}
	
	// Creación de Getters y Setters para cada variable
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	// Inicialización y uso de los acciones creadas en la interface DepositoRetiro
    @Override
    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depósito de $" + monto + " realizado con éxito. Nuevo saldo: $" + saldo);
    }
    
    @Override
    public void retirar(double monto) {
        if (monto > saldo) {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        } else {
            saldo -= monto;
            System.out.println("Retiro de $" + monto + " realizado con éxito. Nuevo saldo: $" + saldo);
        }
    }
}
