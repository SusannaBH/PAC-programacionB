import java.util.ArrayList;
import java.util.List;


public class Cuenta {
    //ATRIBUTOS
    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;
        
    //CONSTRUCTOR CON ARGUMENTOS
    public Cuenta(Usuario usuario) {
        this.saldo = 0; //Un saldo inicial de 0 euros
        this.usuario = usuario;
        this.gastos = new ArrayList<>(); //Listas
        this.ingresos = new ArrayList<>(); //Listas
    }
    
    //GETTERS Y SETTERS
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //ADD INGRESOS
    public double addIngresos (String description, double cantidad) {
	ingresos.add(new Ingreso(cantidad, description));
	saldo += cantidad;
        return saldo;
    }
    
    //ADD GASTOS
    public double addGastos (String description, double cantidad) throws GastoException {
	if (saldo - cantidad < 0) {
            throw new GastoException();
	} 
        else {
            gastos.add(new Gasto(cantidad, description));
            saldo -= cantidad;
	}
        return saldo;
    }
    
    public List<Ingreso> getIngresos() {
        return ingresos;
    }
    
    public List<Gasto> getGastos() {
        return gastos;
    }
    
    //TOSTRING que devuelva el usuario y su saldo
    @Override
    public String toString() {
        return "Usuario: " + usuario + " Saldo: " + saldo;
    }
}
