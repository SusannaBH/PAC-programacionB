public class GastoException extends Exception {
    
    //CONSTRUCTOR CON MENSAJE ERROR
    public GastoException(){
        super("--ERROR: NO HAY SALDO SUFICIENTE EN LA CUENTA.");
    }
}
