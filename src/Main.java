import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        //ATRIBUTOS
        boolean DNIcorrecto;
        int opcion = -1;
        String descripcion;
        double cantidad;
            
        Scanner sc = new Scanner(System.in);
        //CREAR USUARIO
        Usuario usuario = new Usuario();
            //Nombre
        System.out.println("¡Bienvenido a la aplicacion M03B!\n\nIntroduce el nombre del nuevo usuario: ");
        usuario.setNombre(sc.nextLine());
            //Edad
        System.out.println("Introduce la edad del usuario: ");
        usuario.setEdad(sc.nextInt()); //Utilizo nextInt() para así coger datos numericos enteros
        sc.nextLine(); //Este Scanner es para limpiar el buffer
            //DNI (Comprobamos formato correcto)
        System.out.println("Introduce el DNI del usuario: ");
        do {
            DNIcorrecto = usuario.setDNI(sc.nextLine());
            if(DNIcorrecto){
                System.out.println("El DNI " + usuario.getDNI() + " es correcto.");
            } else {
                System.out.println("El DNI introducido es incorrecto.(FORMATO CORRECTO 00000000X o 00000000-X)");
            }
        } while (!DNIcorrecto);
        
        System.out.println("\nEl usuario " + usuario.getNombre() + " se ha creado correctamente.\n");
        Cuenta cuenta = new Cuenta(usuario);//Asignamos los datos a la nueva cuenta

        //CREAR MENU
        while (opcion != 0) {
            System.out.println("Realiza una nueva accion:\n1 Introduce un nuevo gasto"
                                + "\n2 Introduce un nuevo ingreso\n3 Mostrar gastos"
                                + "\n4 Mostrar ingresos\n5 Mostrar saldo\n0 Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            
            //OPCIONES DEL MENU
            switch (opcion) {
                case 1 :   {
                    //REALIZAR UN GASTO
                    System.out.println("Por favor, introduce el concepto del nuevo gasto: ");
                    descripcion = sc.nextLine();
                    
                    System.out.println("Introduce la cantidad: ");
                    cantidad = sc.nextDouble();
                    sc.nextLine();
                    
                    try {
                        System.out.println("Saldo actual: " + formatoEs(cuenta.addGastos(descripcion, cantidad)) + "€");
                        System.out.println();
                    } 
                    catch (GastoException error) {
                        System.err.println(error.getMessage());
                        System.out.println("El saldo actual de la cuenta es de " + formatoEs(cuenta.getSaldo()) + "€.");
                    }
                    break;
                }
                case 2 :   {
                    //REALIZAR UN INGRESO
                    System.out.println("Por favor, introduce el concepto del nuevo ingreso: ");
                    descripcion = sc.nextLine();
                    
                    System.out.println("Introduce la cantidad: ");
                    cantidad = sc.nextDouble();
                    sc.nextLine();
                    
                    System.out.println("Saldo actual: " + formatoEs(cuenta.addIngresos(descripcion, cantidad)) + "€");
                    System.out.println();
                    break;
                }
                case 3 :   {
                    //MOSTRAR GASTOS
                    System.out.println("~GASTOS~");
                    if (cuenta.getGastos().isEmpty()) {
                        System.out.println("------ No hay gastos.");
                    } 
                    else {
                        for (Gasto gasto : cuenta.getGastos()) {
                            System.out.println(gasto.toString());
                        }
                        System.out.println();
                    }
                    break;
                }
                case 4 :   {
                    //MOSTRAR INGRESOS
                    System.out.println("~INGRESOS~");
                    if (cuenta.getIngresos().isEmpty()) {
                        System.out.println("------ No hay ingresos.");
                    } 
                    else {
                        for (Ingreso ingreso : cuenta.getIngresos()) {
                            System.out.println(ingreso.toString());
                        }
                        System.out.println();
                    }
                    break;
                }
                case 5 :   {
                    //MOSTRAR SALDO
                    System.out.println("El saldo actual de la cuenta es de " + formatoEs(cuenta.getSaldo()) + "€.\n");
                    break;
                }
                case 0 :   {
                    //SALIR - FIN DEL PROGRAMA
                    System.out.println("Fin del programa.\nGracias por utilizar la aplicación de M03B en el curso 1s2223.");
                    break; //La frase la pongo con salto de línea (\n) porque en el pdf sale en dos lineas
                }
            }
        }
        sc.close(); //Cerramos Scanner para liberar la memoria
    }
    
    //FORMATO EUROPEO DINERO €
    public static String formatoEs (double valor) {
	Locale spanish = new Locale("es", "ES");
	NumberFormat nf = NumberFormat.getInstance(spanish);
	return nf.format(valor);
    }
}
