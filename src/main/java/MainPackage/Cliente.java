/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MainPackage;
import EnumPackage.TipoCliente;
import EnumPackage.Perfil;
import static MainPackage.SistemaVehicular.usuariosRegistrados;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author gabsy
 */

//Creación de clase 'Cliente que hereda de 'Usuario'
public class Cliente extends Usuario {
    //Atributos de instancia de la clase 'Cliente'   
    private TipoCliente tipo; 
    private String numTarjetaCred;
    private int puntosLicencia; 
    private Vehiculo vehiculo;
    
    public Cliente(String cedula, String nombres, String apellidos, int edad, String correo, String usuario, String contrasena, Perfil perfil, TipoCliente tipo, String numTarjetaCred, int puntosLicencia, Vehiculo vehiculo){
        //invocación del constructor de la clase padre
        super(cedula, nombres, apellidos, edad, correo, usuario, contrasena, perfil);
        this.tipo = tipo;
        this.numTarjetaCred = numTarjetaCred;
        this.puntosLicencia = puntosLicencia;
        this.vehiculo = vehiculo;
    
    }
    public TipoCliente getTipoCliente(){
        return tipo;
    }

    @Override
    public void opcionesMenu(){
      Scanner sc = new Scanner(System.in);
      int opcion;
      
      //Opciones para el Usuario Cliente
    do{  
        System.out.println("-".repeat(50));
        System.out.println("                 OPCIONES CLIENTE                 ");
        System.out.println("-".repeat(50));
        System.out.println(" ");
        System.out.println("1. Consultar Multas");
        System.out.println("2. Agendar Revisión técnica");
        System.out.println("3. Salir");
        System.out.print("Ingrese el número de la opción que desea: ");  
        try{
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion < 1 || opcion > 3) { //validar que solo ingrese numeros del 1-3
                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            } else {
                switch (opcion) {
                    case 1:
                        consultarMultas();
                        break;
                    case 2:
                        //tu otro metodo de agendar revision tecnica
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                }
            }
        } catch (InputMismatchException e) { //validar que no ingrese caracteres diferentes de numeros
            System.out.println("Opción inválida. Por favor, ingrese un número válido.");
            sc.nextLine(); // Limpiar el búfer
            opcion = 0; // Establecer la opción en 0 para repetir el ciclo
        }
    } while (opcion != 3);
}
      


    @Override
    //Sobreescritura del método toString()
    public String toString(){
        return "Tipo de cliente: "+ tipo +"/nPuntos de Licencia: "+ puntosLicencia+ "/nVehiculo:/n"+ vehiculo.toString();
    }
    
    //Sobreecritura del método consultarMultas() de la clase padre
    @Override
    public void consultarMultas(){
        //Menú del método
        Scanner sc = new Scanner(System.in);
        System.out.println("-".repeat(50));
        System.out.printf("                CONSULTA DE MULTAS                ");
        System.out.println("-".repeat(50));
        System.out.println(" ");
        System.out.println("Ingrese su  matrícula o cédula: ");
        String matri_ci = sc.nextLine();
        sc.nextLine();
        
        ArrayList<String> lineas = ManejoArchivo.LeeFichero("multas.txt");
        ArrayList<String> multasC = new ArrayList<>();   
        
        //Verificar las multas que pertenecen al cliente, a través de su cédula
        for(String l : lineas){
            String[] l2 = l.split(",");
            if(matri_ci.equals(l2[0]) || matri_ci.equals(l2[1])){
                multasC.add(l);
            } 
        }

        //Formato de las multas
        System.out.println("-".repeat(50));
        System.out.printf("                DETALLE DE MULTAS                 ");
        System.out.println("-".repeat(50));
        System.out.println(" ");
        System.out.println("CÉDULA | MATRÍCULA | INFRACCIÓN | VALOR A PAGAR | FECHA DE INFRACCIÓN | FECHA DE NOTIFICACIÓN | PUNTOS");
        
        int saldo = 0;
        for(String multas : multasC){
            String[] datos = multas.split(",");
            saldo =+ Integer.valueOf(datos[3]);
            System.out.printf("%6s | %6s | %6s | %6s | %6s | %6s | %6s",datos[0], datos[1], datos[2],datos[3],datos[4],datos[5],datos[6]);
        }
        
        System.out.println("TOTAL A PAGAR: " + saldo);
        System.out.println("PARA PAGAR PUEDE ACERCARSE A LA AGENCIA MÁS CERCANA.");
        
    }
}