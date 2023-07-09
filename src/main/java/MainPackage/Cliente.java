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
import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;

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
    
    //objetos necesarios para la ejecucion del código
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    
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
    
    //Método AgendarRevision(). El método retornará un arreglo con los datos del horario que el cliente escogió
    public ArrayList<String> AgendarRevision(){
        
        System.out.println("--------------------------------------------------");
        System.out.printf("%32s","AGENDAR REVISIÓN");
        System.out.println("\n--------------------------------------------------");
        
        ArrayList<String> multas = ManejoArchivo.LeeFichero("multas.text");
        System.out.println("Ingrese su placa: ");
        String placa = sc.nextLine(); 
        sc.nextLine();
        
        //Placas con multas
        ArrayList<String> placas_multas = new ArrayList<>();
        for(String l : multas){
            String[] l2 = l.split(",");
            placas_multas.add(l2[1]);
            
        }
        
        //Verificar si la placa tiene multas
        if(placas_multas.contains(placa)){
            System.out.println("Tiene multas pendientes por pagar");
        } else{
            System.out.println("No tiene multas.");
        }
        
        //Impresión de Horarios Disponibles
        System.out.println("Horarios Disponibles");
        
        ArrayList<String> horarios = ManejoArchivo.LeeFichero("HorariosRevisio.txt");
        ArrayList<String> opciones = new ArrayList<>(); //para tener una noción de las opciones de horarios
        
        for(String horario : horarios){
            String[] datos = horario.split(" ");
            opciones.add(datos[0].substring(0, datos[0].length() - 1));
            System.out.println(horario);
        }
        
        //Pedir al cliente que elija una opción de horario
        System.out.println("Elija una opción de horario");
        String op = sc.nextLine();
        sc.nextLine();
        
        //verificar que la opción introducida este entre las opciones
        while(!opciones.contains(op)){
            System.out.println("La opción no es correcta");
            System.out.println("Elija una opción de horario: ");
            op = sc.nextLine();
        }
        
        
        //Creacion del arreglo con los datos del horario escogido
        ArrayList<String> horario_escodigo = new ArrayList<>();
        //Array que recibe los datos para el archivo de 'CitasAgendadas'
        ArrayList<String> citasAgendadas = new ArrayList<>();
        
        citasAgendadas.add(2, placa);
        
        for(String horario : horarios){
            String[] datos = horario.split(" ");           
            if(horario.contains(op)){
                horario_escodigo.add(horario);
                citasAgendadas.add(3, datos[1]);
                
            }
        }
        
        /*Creacion de un numero aleatorio de 4 digitos para el 'CodigoUnico' 
        del horario. A su vez se agrega este dato al array de citasAgendadas*/
        GeneracionCodigoUnico cd = new GeneracionCodigoUnico();
        int cod = cd.generarCodigoUnico();
        citasAgendadas.add(0, String.valueOf(cod));
        
        //lectura de archivo multas.txt para obtener la cédula del cliente segun la placa
        ArrayList<String> mult = new ArrayList<>();
        for(String multa : mult){
            String[] dato = multa.split(",");
            if(dato[1].equals(placa)){
                citasAgendadas.add(1, dato[0]);
            }
        }
        
        //String de los datos del array para poderlos escribir directamente en el archivo
        StringBuilder sb = new StringBuilder();
        for(String dato : citasAgendadas){
            sb.append(dato).append(", ");
        }
        
        // Eliminar la última coma y el espacio
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);  
        }
        
        
        //Escritura de archivo con horarios escogidos;
        
        try{
            File f = new File("CitasAgendadas.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            //para escribir los datos del horario en el archivo
            pw.write(sb.toString());
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "ha sucedido un error"+e);
        }
     
        //retorno del arreglo
        return horario_escodigo;
    }
    
    //metodo para calcular el valor a pagar de la revision. El metodo recibe un cliente 
    public int valorRevision(Cliente c){
        int base = 150;
        int valorPagar = 0;
        
        //verificar el tipo de cliente que es
        if(c.tipo == TipoCliente.ESTRELLA){
            valorPagar = base - base*(20/100);
        } else if(c.tipo == TipoCliente.ESTANDAR){
            valorPagar = base + (c.puntosLicencia*10);
        }
        return valorPagar;
    }
    
    
}