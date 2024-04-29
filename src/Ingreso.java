public class Ingreso extends Dinero{

    //CONTRUCTOR con argumentos
    public Ingreso(double ingreso, String description) {
        
        super.setDinero(ingreso);
        super.setDescription(description);
    }
    
    //Metodo ToString() que muestra datos de ingreso
    @Override
    public String toString() {
        return "Ingreso: " + Main.formatoEs(super.getDinero()) + "€ - Descripcion: " + super.getDescription();
    }
}
