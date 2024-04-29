
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
    
    //ATRIBUTOS
    private String nombre;
    private int edad;
    private String DNI;
    
    //CONSTRUCTOR SIN ARGUMENTOS
    public Usuario() {

    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    //CREAR FORMATO DNI (00000000-X o 00000000X) con expresion regular
    public boolean setDNI(String DNI) {
        Pattern patron = Pattern.compile("^[0-9]{8}-*[A-Z]$");  //Patron
        Matcher DNICorrecto = patron.matcher(DNI);            //Comprobacion
        
        if (DNICorrecto.matches()) {
            this.DNI = DNI;
            return true;
        } else {
            return false;
        }
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + '}';
    }
}
