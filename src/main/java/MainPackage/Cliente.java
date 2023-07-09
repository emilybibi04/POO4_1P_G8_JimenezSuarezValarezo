/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MainPackage;
import EnumPackage.TipoCliente;
import EnumPackage.Perfil;
import java.util.Scanner;
import java.util.ArrayList;

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

    @Override
    public void opcionesMenu(){
      Scanner sc = new Scanner(System.in);
      
      //Opciones para el Usuario Cliente
      System.out.println("-".repeat(50));
      System.out.println("                 OPCIONES CLIENTE                 ");
      System.out.println("-".repeat(50));
      System.out.println(" ");
      System.out.println("1. Consultar Multas");
      System.out.println("2. Agendar Revisión técnica");
      System.out.print("Ingrese el número de la opción que desea: ");  
      int opcion = sc.nextInt();
      
      //validación de la opción elegida, esta debe de ser uno 1 o 2
      while(opcion!=1 && opcion != 2){
            System.out.println("Ingrese una opción correcta");
            System.out.println("-".repeat(50));
            System.out.println("                 OPCIONES CLIENTE                 ");
            System.out.println("-".repeat(50));
            System.out.println("1. Consultar Multas");
            System.out.println("2. Agendar Revisión técnica");
            System.out.println("Ingrese el número de la opción que desea: ");
            opcion = sc.nextInt();
        } 
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