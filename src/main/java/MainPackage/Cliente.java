/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import EnumPackage.TipoCliente;
import EnumPackage.Perfil;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author gabsy
 */

//Creación de clase 'Cliente que hereda de 'Usuario' para hacer uso de sus atributos y sobreescribir sus métodos. 
public class Cliente extends Usuario {
    //Atributos de instancia de la clase 'Cliente'   
    private TipoCliente tipo; 
    private int numTarjetaCred;
    private int puntosLicencia; 
    private Vehiculo vehiculo;
    
    public Cliente(String cedula, String nombres, String apellidos, int edad, String correo, String usuario, String contrasena, Perfil perfil, TipoCliente tipo, int numTarjetaCred, int puntosLicencia, Vehiculo vehiculo){
        //invocación del constructor de la clase padre
        super(cedula, nombres, apellidos, edad, correo, usuario, contrasena, perfil);
        
        this.tipo = tipo;
        this.numTarjetaCred = numTarjetaCred;
        this.puntosLicencia = puntosLicencia;
        this.vehiculo = vehiculo;
    
    }
    
    //Sobreescritura del método mostrarOpciones de la clase SistemaVehicular
    @Override
    public void mostrarOpciones(Usuario u){
      Scanner sc = new Scanner(System.in);
      
      //Opciones para el Usuario Cliente
      System.out.println("--------------------------------------------------");
      System.out.printf("%32s","OPCIONES CLIENTE");
      System.out.println("\n--------------------------------------------------");
      System.out.println("1. Consultar Multas");
      System.out.println("2. Agendar Revisión técnica");
      System.out.println("Ingrese el número de la opción que desea: ");  
      int opcion = sc.nextInt();
      
      //validación de la opción elegida, esta debe de ser uno 1 o 2
      while(opcion!=1 && opcion != 2){
            System.out.println("Ingrese una opción correcta");
            System.out.println("--------------------------------------------------");
            System.out.printf("%32s","OPCIONES CLIENTE");
            System.out.println("\n--------------------------------------------------");
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
        
    }
}
