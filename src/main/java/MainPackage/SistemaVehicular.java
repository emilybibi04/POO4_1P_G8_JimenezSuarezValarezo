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
    
    static ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("+".repeat(32));
        System.out.println(" ");
        System.out.println("     BIENVENIDO AL SISTEMA     ");
        System.out.println(" ");
        System.out.println("+".repeat(32));
        System.out.println(" ");
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();
        cargarUsuario();
        comprobarUsuario(user, pass, usuariosRegistrados);
    }
    
    public static void cargarUsuario (){
        ArrayList<String> datos = ManejoArchivo.LeeFichero("usuarios.txt");
        for(String linea: datos){
            Perfil p = Perfil.UNDEFINED;
            String[] elemento = linea.trim().split(",");
            String cedulaA = elemento[0];
            String[] nombresA = elemento [1].trim().split(" ");
            String nombreA = nombresA[0];
            String apellidoA = nombresA[1];
            int edadA = Integer.parseInt(elemento [2]);
            String correoA = elemento [3];
            String usuarioA = elemento [4];
            String contrasenaA = elemento [5];
            String perfilA = elemento [6];
            
            switch(perfilA){
                case "O":
                    p = Perfil.OPERADOR;
                    break;
                case "E":
                    p = Perfil.CLIENTE;
                    break;
                case "S":
                    p = Perfil.CLIENTE;
                    break;
            }
            
            Usuario u = new Usuario(cedulaA, nombreA, apellidoA, edadA, correoA, usuarioA, contrasenaA, p);
            usuariosRegistrados.add(u);
            } 
    }
    
    public static boolean comprobarUsuario(String user, String pass, ArrayList<Usuario> lista){
        for (Usuario u : lista) {
            if (u.getUsuario().equals(user) && u.getContrasena().equals(pass)) {
                return true;
            }
        }
        return false;
    }

}
    
