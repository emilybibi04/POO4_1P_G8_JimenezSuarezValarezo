/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MainPackage;
import EnumPackage.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

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
    private Revision revision;
    
    //objetos necesarios para la ejecucion del código
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    
    /**
     * Constructor de la clase Cliente.
     * @param cedula          La cédula del cliente.
     * @param nombres         Los nombres del cliente.
     * @param apellidos       Los apellidos del cliente.
     * @param edad            La edad del cliente.
     * @param correo          El correo del cliente.
     * @param usuario         El nombre de usuario del cliente.
     * @param contrasena      La contraseña del cliente.
     * @param perfil          El perfil del cliente.
     * @param tipo            El tipo de cliente.
     * @param numTarjetaCred  El número de tarjeta de crédito del cliente.
     * @param puntosLicencia  Los puntos de licencia del cliente.
     * @param vehiculo        El vehículo asociado al cliente.
     */
    
    public Cliente(String cedula, String nombres, String apellidos, int edad, String correo, String usuario, String contrasena, Perfil perfil, TipoCliente tipo, String numTarjetaCred, int puntosLicencia, Vehiculo vehiculo){
        //invocación del constructor de la clase padre
        super(cedula, nombres, apellidos, edad, correo, usuario, contrasena, perfil);
        this.tipo = tipo;
        this.numTarjetaCred = numTarjetaCred;
        this.puntosLicencia = puntosLicencia;
        this.vehiculo = vehiculo;
        this.revision=new Revision();
    }
    
    /**
     * Método getter que obtiene el tipo de cliente.
     * @return El tipo de cliente.
     */
    
    public TipoCliente getTipoCliente(){
        return tipo;
    }

    /**
     * Método sobreescrito que permite observar el Menú de Clientes.
     * {@inheritDoc}
     */
    
    @Override
    public void opcionesMenu(){
      Scanner sc = new Scanner(System.in);
      int opcion;
      
      //Opciones para el Usuario Cliente
    do{  
        System.out.println("-".repeat(50));
        System.out.println("                 OPCIONES CLIENTE                 ");
        System.out.println("-".repeat(50)+"\n");
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
                        agendarRevision();
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

    /**
     * Método getter que obtiene el tipo de usuario.
     * @return El tipo de usuario.
     */
    
    public TipoCliente getTipo() {
        return tipo;
    }

    /**
     * Método getter que obtiene los puntos de licencia del cliente.
     * @return Los puntos de licencia del cliente.
     */
    
    public int getPuntosLicencia() {
        return puntosLicencia;
    }
      
    
    /**
     * Sobreescritura del método toString() para poder representar el objeto en forma de cadena de texto.
     * {@inheritDoc}
     */

    @Override
    public String toString(){
        return "Tipo de cliente: "+ tipo +"/nPuntos de Licencia: "+ puntosLicencia+ "/nVehiculo:/n"+ vehiculo.toString();
    }
    
    /**
     * Sobreecritura del método consultarMultas() de la clase padre
     * {@inheritDoc}
     */

    @Override
    public void consultarMultas(){
        //Menú del método
        Scanner sc = new Scanner(System.in);
        System.out.println("-".repeat(50));
        System.out.println("                CONSULTA DE MULTAS                ");
        System.out.println("-".repeat(50)+"\n");
        String matri_ci;
        boolean check=true;
        
        ArrayList<String> lineas = ManejoArchivo.LeeFichero("multas.txt");
        ArrayList<String> multasC = new ArrayList<>();   
        
        
        do {
            System.out.print("Ingrese su matrícula o cédula: ");
            matri_ci = sc.nextLine();
            if(matri_ci.equals(this.cedula) || matri_ci.equals(vehiculo.getPlaca()))
                check=false;  
            
        } while (check==true);
        
       
        
        //Verificar las multas que pertenecen al cliente, a través de su cédula
        for(String l : lineas){
            if(!l.equals("************************") && !l.replace("\n", "").isEmpty()){
                String[] l2 = l.trim().split(",");
                if(matri_ci.equals(l2[0]) || matri_ci.equals(l2[1]))
                    multasC.add(l);
            } 
        }

        //Formato de las multas
        System.out.println("-".repeat(50));
        System.out.println("                DETALLE DE MULTAS                 ");
        System.out.println("-".repeat(50));
        System.out.println(" ");
        System.out.println("CÉDULA | MATRÍCULA | INFRACCIÓN | VALOR A PAGAR | FECHA DE INFRACCIÓN | FECHA DE NOTIFICACIÓN | PUNTOS");
        
        double saldo = 0;
        for(String multas : multasC){
            String[] datos = multas.split(",");
            saldo =+ Double.parseDouble(datos[3]);
            System.out.printf("%6s | %6s | %6s | %6s | %6s | %6s | %6s\n",datos[0], datos[1], datos[2],datos[3],datos[4],datos[5],datos[6]);
        }
        
        System.out.println("TOTAL A PAGAR: " + saldo);
        System.out.println("PARA PAGAR PUEDE ACERCARSE A LA AGENCIA MÁS CERCANA.");
        
    }
    
    /**
     * Método que permite agendar una revisión técnica.
     * El método retornará un arreglo con los datos del horario que el cliente escogió
     */
    
    public void agendarRevision(){
        
        System.out.println("--------------------------------------------------");
        System.out.printf("%32s\n","AGENDAR REVISIÓN");
        System.out.println("--------------------------------------------------");
        
        ArrayList<String> multas = ManejoArchivo.LeeFichero("multas.txt");
        
        //Placas con multas
        ArrayList<String> placas_multas = new ArrayList<>();
        for(String l : multas){
            if(!l.equals("************************") && !l.replace("\n", "").isEmpty()){
                String[] l2 = l.trim().split(",");
                placas_multas.add(l2[1]);
            }
        }
        String placa;
        boolean condicion;
        do{
            System.out.print("Ingrese su placa: ");
            placa = sc.nextLine();
            condicion=!vehiculo.getPlaca().equals(placa);
            if(condicion)
                System.out.println("Placa no registrada a su nombre, ingrese placa correcta");
        }
        while(condicion);
        
        ArrayList<String> revisiones=ManejoArchivo.LeeFichero("CitasAgendadas.txt");
        boolean tieneRevision=false;
        for(String linea: revisiones){
            if(!linea.replace("\n", "").isEmpty()){
                String[] datos=linea.trim().split(",");
                if(datos[1].equals(this.cedula))
                    tieneRevision=true;
            }
        }
        
        
        if(placas_multas.contains(placa))
            System.out.println("No puede agendar una revision, usted tiene multas pendientes por pagar");
        else if(tieneRevision){
            for(String linea:revisiones){
                if(!linea.replace("\n", "").isEmpty()){
                    String[] datos=linea.trim().split(",");
                    if(datos[1].equals(cedula))
                        this.setRevision(new Revision(datos[0],datos[1],datos[2],datos[3]));
                }
            }
            System.out.println(this.nombres+" "+this.apellidos+", ya tiene una cita agendada para el "+revision.getFecha());
            System.out.println("Valor a pagar: "+revision.valorRevision(this)+"\n");
        }
        else{
            System.out.println("No tiene multas.\n");
        
            //Impresión de Horarios Disponibles
            System.out.println("Horarios Disponibles");

            ArrayList<String> horarios = ManejoArchivo.LeeFichero("HorariosRevision.txt");
            ArrayList<String> opciones = new ArrayList<>(); //para tener una noción de las opciones de horarios

            for(String horario : horarios){
                if(!horario.equals("************************") && !horario.replace("\n", "").isEmpty()){
                    String[] datos = horario.trim().split(" ");
                    String indice=datos[0].substring(0, datos[0].length() - 1);
                    if(Utilitaria.esEntero(indice))
                        opciones.add(indice);
                }
            }
            
            for(String p:opciones){
                int posicion=Integer.parseInt(p)-1;
                System.out.println(horarios.get(posicion));
            }

            //Pedir al cliente que elija una opción de horario
            System.out.println("Elija una opción de horario");
            String op = sc.nextLine();

            //verificar que la opción introducida este entre las opciones
            while(!opciones.contains(op)){
                System.out.println("La opción no es correcta");
                System.out.print("Elija una opción de horario: ");
                op = sc.nextLine();
            }


            //Creacion del arreglo con los datos del horario escogido
            String[] horario_escogido=horarios.get(Integer.parseInt(op)-1).trim().split(" ");
            //Array que recibe los datos para el archivo de 'CitasAgendadas'
            String[] citaAgendada = new String[4];

            citaAgendada[2]=placa;

            citaAgendada[3]=horario_escogido[1];

            /*Creacion de un numero aleatorio de 4 digitos para el 'CodigoUnico' 
            del horario. A su vez se agrega este dato al array de citasAgendadas*/
            GeneracionCodigoUnico cd = new GeneracionCodigoUnico();
            int cod = cd.generarCodigoUnico();
            citaAgendada[0]=String.valueOf(cod);
            
            ArrayList<String> vehiculos = ManejoArchivo.LeeFichero("vehiculos.txt");    
                
            for(String vehiculo : vehiculos){
                String[] dato = vehiculo.trim().split(",");
                if(dato[1].equals(placa)){
                    citaAgendada[1]=dato[0];
                }
            }
    
            setRevision(new Revision(String.valueOf(cod),citaAgendada[1],citaAgendada[2],citaAgendada[3]));
            
            //String de los datos del array para poderlos escribir directamente en el archivo
            String cita = citaAgendada[0]+","+citaAgendada[1]+","+citaAgendada[2]+","+citaAgendada[3];
            //Escritura de archivo con horarios escogidos;
            revision.registrarRevision(cita);
            
            System.out.println(this.nombres+" "+this.apellidos+", se ha agendado su cita para el "+horario_escogido[1]+" a las "+horario_escogido[2]);
            System.out.println("Valor a pagar: "+revision.valorRevision(this)+"\n");
            System.out.println("Puede pagar su cita hasta 24 horas antes de la cita.\nDe lo contrario la cita se cancelara.");
            
            try {
                Path ruta = Paths.get("HorariosRevision.txt"); // Ruta al archivo original
              
                for(String line:horarios){
                    if(!line.equals("************************") || !line.replace("\n", "").isEmpty()){
                        String[] datos=line.trim().split(" ");
                        String pos=datos[0].substring(0, datos[0].length() - 1);
                        if(pos.equals(op))
                            horarios.set(Integer.parseInt(pos) - 1, "************************");
                    }
                }

                Files.write(ruta, horarios);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Método setter de la revisión.
     * @param r La revisión a establecer.
     */
    
    public void setRevision(Revision r){
        this.revision = r;
    }
    
    
}