/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MainPackage;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author emilyvalarezo
 */
public class SistemaVehicular {
    
    static ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();

    /**
     * Método principal del sistema vehicular.
     * Invoca el método para ejecutar la interfaz.
     * @param args Argumentos de línea de comandos (no se utilizan en este caso).
     */
    
    public static void main(String[] args){
        ejecutarInterfaz();
    }
    
    /**
     * Ejecuta la interfaz del sistema vehicular.
     * Solicita el ingreso de usuario y contraseña, verifica su validez
     * y realiza las acciones correspondientes según el tipo de usuario.
     */
    
    public static void ejecutarInterfaz(){
        Scanner sc = new Scanner(System.in);
        System.out.println("+".repeat(50));
        System.out.println("              BIENVENIDO AL SISTEMA               ");
        System.out.println("+".repeat(50));
        System.out.println(" ");
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();
        usuariosRegistrados = Utilitaria.cargarUsuario();
        boolean validar = Utilitaria.comprobarUsuario(user, pass, usuariosRegistrados);
        if(validar){
            System.out.println("Su inicio de sesión ha sido exitoso\n");
            Usuario obj = null;
            for(Usuario u : usuariosRegistrados){
                if(u.getUsuario().equals(user)){
                    obj = u;
                }
            }
            Utilitaria.comprobarTipo(obj);
        } else {
            System.out.println("Su usuario o contraseña son incorrectos");
        }
    }
    
}