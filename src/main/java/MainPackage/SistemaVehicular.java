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
public class SistemaVehicular {
    
    
    
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
        System.out.println("Contraseña");
        String pass = sc.nextLine();
    }
    
    public static void cargarUsuario (){
        ArrayList<String> datos = ManejoArchivo.LeeFichero("usuarios.txt");
        for(String linea: datos){
            Perfil p = Perfil.UNDEFINED;
            String[] elemento = linea.trim().split(",");
//            String cedulaA = elemento[0];
//            String nombreA = elemento [1];
//            int edadA = Integer.parseInt(elemento [2]);
//            String correoA = elemento [3];
//            String usuarioA = elemento [4];
//            String contrasenaA = elemento [5];
            String perfilA = elemento [6];
            
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
    }
 
}
    
