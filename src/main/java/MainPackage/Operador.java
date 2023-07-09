/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MainPackage;
import EnumPackage.Perfil;
import static MainPackage.SistemaVehicular.usuariosRegistrados;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
//imports para el tiempo
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.InputMismatchException;


/**
 *
 * @author gabsy
 */

/* La clase 'Operador', creará objetos de tipo Operador para representar una de las clasificaciones de los Usuarios 
   posibles del Sistema Vehicular. Un Usuario es del tipo Operador si...
*/

public class Operador extends Usuario {
    //atributo de instancia de 'Operador'
    private double sueldo;
     
    public Operador(String cedula, String nombres, String apellidos, int edad, String correo, String usuario, String contrasena, Perfil perfil, double sueldo){
        //invocación del constructor de la clase padre
        super(cedula, nombres, apellidos, edad, correo, usuario, contrasena, perfil);
        this.sueldo=sueldo;
     }
     
    public double getSueldo(){
       return sueldo;
    }
    //sobreescritura del metodo opcionesMenu
    @Override
    public void opcionesMenu() {
    usuariosRegistrados = Utilitaria.cargarUsuario();
    Scanner sc = new Scanner(System.in);
    int opcion;

    // Opciones para el Usuario Cliente
    do {
        System.out.println("--------------------------------------------------");
        System.out.printf("%32s", "OPCIONES OPERADOR");
        System.out.println("\n--------------------------------------------------");
        System.out.println("1. Registrar Pagos");
        System.out.println("2. Consultar multas clientes");
        System.out.println("3. Consultar usuarios");
        System.out.println("4. Salir");
        System.out.print("Ingrese el número de la opción que desea: ");

        try {
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion < 1 || opcion > 4) { //validar que solo ingrese numeros del 1-4
                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            } else {
                switch (opcion) {
                    case 1:
                        registrarPagos();
                        break;
                    case 2:
                        consultarMultas();
                        break;
                    case 3:
                        consultarUsuarios(usuariosRegistrados);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                }
            }
        } catch (InputMismatchException e) { //validar que no ingrese caracteres diferentes de numeros
            System.out.println("Opción inválida. Por favor, ingrese un número válido.");
            sc.nextLine(); // Limpiar el búfer
            opcion = 0; // Establecer la opción en 0 para repetir el ciclo
        }
    } while (opcion != 4);
}
    public void registrarPagos(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Usuario> lista=Utilitaria.cargarUsuario();
        System.out.println("--------------------------------------------------");
        System.out.printf("%32s","REGISTRAR PAGO");
        System.out.println("\n--------------------------------------------------");
        System.out.print("\n Ingrese su numero de cédula: ");
        String cedula=sc.nextLine();
//        for (Usuario u: lista){
//                if (u.getCedula().equals(cedula)){
//                    
//                }
//            }    
    }
    
    @Override
    public void consultarMultas(){
        //Establecer una fecha actual para el proyecto con Date
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();        
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MMMM", new Locale("es"));
        String nombreMes = fechaActual.format(formateador);
        String mesMayus = nombreMes.substring(0, 1).toUpperCase() +nombreMes.substring(1);
        //cargar el ArrayList de los usuarios
        ArrayList<Usuario> lista=Utilitaria.cargarUsuario();
        System.out.println("--------------------------------------------------");
        System.out.printf("%32s","CONSULTAR MULTAS");
        System.out.println("\n--------------------------------------------------\n");
        System.out.println("Mes: "+mesMayus+"\n");
        System.out.printf("%32s","Conductores multados\n");
        System.out.println("CONDUCTOR | PLACA | INFRACCIÓN | VALOR INFRACCIÓN | FECHA INFRACCIÓN | FECHA NOTIFICACIÓN | PUNTOS");
        //cargar el ArraList de las multas  
        ArrayList<String> multas = ManejoArchivo.LeeFichero("multas.txt");
        for(String linea: multas){ 
            String[] elemento = linea.trim().split(",");
            String cedula= elemento[0];
            String nombre="";
            for (Usuario u: lista){
                if (u.getCedula().equals(cedula)){ //comparar la cedula en el archivo multas  con la de usuarios
                    nombre=u.getNombres()+" "+u.getApellidos();
                }
            }
            String placa= elemento [1];
            String infraccion= elemento [2];
            double valor= Double.parseDouble(elemento[3]);
            String fecha_infra=elemento[4];
            String fecha_noti= elemento [5];
            int puntos=Integer.parseInt(elemento[6]);
            String[] fecha= elemento[4].trim().split("-");
            int mesMulta=Integer.parseInt(fecha[1]);
            if (mesMulta==mesActual){
                System.out.println(nombre+","+placa+","+infraccion+","+valor+","+fecha_infra+","+fecha_noti+","+puntos);
            }
        }
    }
        
    public void consultarUsuarios(ArrayList<Usuario> lista){
        System.out.println("--------------------------------------------------");
        System.out.printf("%32s","CONSULTAR USUARIOS");
        System.out.println("\n--------------------------------------------------");
        System.out.println("");
        for (Usuario u : lista) {
            if (u instanceof Operador){
                Operador operador = (Operador) u;
                System.out.println(operador.getNombres()+" "+operador.getApellidos()+" | "+operador.getPerfil()+ " | "+operador.getSueldo());
            } else if(u instanceof Cliente){
                Cliente cliente = (Cliente) u;
                System.out.println(cliente.getNombres()+" "+cliente.getApellidos()+ " | " +cliente.getPerfil() +" " +cliente.getTipoCliente()+" | "+cliente.getCedula());
            }
        }
    }
     
     
}