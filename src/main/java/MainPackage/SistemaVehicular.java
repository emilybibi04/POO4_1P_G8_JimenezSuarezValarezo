/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import EnumPackage.Perfil;

/**
 *
 * @author emilyvalarezo
 */
public abstract class SistemaVehicular {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("+".repeat(32));
        System.out.println(" ");
        System.out.println("     BIENVENIDO AL SISTEMA     ");
        System.out.println(" ");
        System.out.println("+".repeat(32));
        System.out.println(" ");
        System.out.println("Usuario: ");
        String user = sc.nextLine();
        System.out.println("Contraseña:");
        String pass = sc.nextLine();
        
        System.out.println("");
        cargarUsuario(user,pass);
    }
    
    public static void cargarUsuario (String user, String pass){
        ArrayList<String> datos = ManejoArchivo.LeeFichero("usuarios.txt");
        
        boolean usuarioValido = false;
        
        for(String linea: datos){
            Perfil p = Perfil.UNDEFINED;
            String[] elemento = linea.trim().split(",");
            String cedulaA = elemento[0];
            String nombreA = elemento [1];
            int edadA = Integer.parseInt(elemento [2]);
            String correoA = elemento [3];
            String usuarioA = elemento [4];
            String contrasenaA = elemento [5];
            String perfilA = elemento [6];
                        
            //validacion para saber si el usuario y clave escritos por el usuario sean correctos
            if (usuarioA.equals(user) && contrasenaA.equals(pass)) {
                usuarioValido = true;
                break;
            }
            
            switch(perfilA){
                case "O":
                    p = Perfil.OPERADOR;
                    break;
                case "S":
                    p = Perfil.CLIENTE;
                    break;
                case "E":
                    p = Perfil.CLIENTE;
                    break;
                default:
                    System.out.println("Usuario no válido");
            }
        }
        if (usuarioValido) {
            System.out.println("Su inicio de sesión ha sido exitoso");
        } else {
            System.out.println("Su usuario o contraseña son incorrectos");
        }
    }
    
    
    
    
    
    public abstract void mostrarOpciones(Usuario usuario);
 
}
    
