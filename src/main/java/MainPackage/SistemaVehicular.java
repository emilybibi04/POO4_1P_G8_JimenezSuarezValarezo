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
    
    
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Operador> operadores = new ArrayList<>();
    
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("+".repeat(32));
        System.out.println("     BIENVENIDO AL SISTEMA     ");
        System.out.println("+".repeat(32));
        System.out.println(" ");
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();
        cargarUsuario();
        boolean validar = comprobarUsuario(user, pass, usuariosRegistrados);
        if (validar){
            System.out.println("Su inicio de sesión ha sido exitoso");
            comprobarTipo();
        } else {
            System.out.println("Su usuario o contraseña son incorrectos");
        }
        
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
    
    public static boolean comprobarUsuario(String user, String pass, ArrayList<Usuario> lista) {
    for (Usuario u : lista) {
        if (u.getUsuario().equals(user) && u.getContrasena().equals(pass)) {
            return true; // Usuario encontrado, retorna true
        }
    }
    return false; // Usuario no encontrado, retorna false
        }
    
//    public static void comprobarTipo(){
//        for (Usuario u : usuariosRegistrados){
//            if(u.getPerfil().equals(Perfil.CLIENTE)){
//                //Cliente cliente = new Cliente();
//                cliente.opcionesMenu();
//        } else if (u.getPerfil().equals(Perfil.OPERADOR)){
//            //Operador operador = (Operador)u;
//            //operador.opcionesMenu();
//        }
//        }
//    }
    
    public static void cargarClientes() {
        ArrayList<String> datos = ManejoArchivo.LeeFichero("clientes.txt");
        for (String linea : datos) {
            String[] elemento = linea.trim().split(",");
            String cedula = elemento[0];
            String tipoClienteStr = elemento[1];
            int numTarjetaCred = Integer.parseInt(elemento[2]);
            
            TipoCliente tipoCliente = TipoCliente.valueOf(tipoClienteStr);
            
            for (Usuario u : usuariosRegistrados) {
                if (u.getCedula().equals(cedula) && u.getPerfil() == Perfil.CLIENTE) {
                    Cliente cliente = (Cliente) u; // Realizar casting a Cliente
                    cliente.setTipo(tipoCliente);
                    cliente.setNumTarjetaCred(numTarjetaCred);
                    clientes.add(cliente);
                    break;
                }
            }
        }
    }
    
    public static void cargarOperadores() {
        for (Usuario u : usuariosRegistrados) {
            if (u.getPerfil() == Perfil.OPERADOR) {
                Operador operador = (Operador) u; // Realizar casting a Operador
                operadores.add(operador);
            }
        }
    }

}
    
