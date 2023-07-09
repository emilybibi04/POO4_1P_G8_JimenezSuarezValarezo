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