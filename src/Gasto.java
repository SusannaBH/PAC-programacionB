public class Gasto extends Dinero{

    //CONTRUCTOR
    public Gasto(double gasto, String description) {
        super.setDinero(gasto);
        super.setDescription(description);
    }
    
    //Metodo ToString() que muestra datos del gasto
    @Override
    public String toString() {
        return "Gasto: " + Main.formatoEs(super.getDinero()) + "€ - Descripcion: " + super.getDescription();
    }
}
