/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MainPackage;
import EnumPackage.Perfil;
import EnumPackage.TipoCliente;
import java.util.ArrayList;

/**
 *
 * @author emilyvalarezo
 */

public class Utilitaria {
    
    /**
     * Carga los usuarios desde el archivo "usuarios.txt" y los devuelve en forma de ArrayList.
     * @return una lista de usuarios
     */
    
    public static ArrayList<Usuario> cargarUsuario(){
        ArrayList<Usuario> usuariosArray = new ArrayList<>();
        ArrayList<String> datos = ManejoArchivo.LeeFichero("usuarios.txt");
        for(String linea : datos){
            Perfil p;
            TipoCliente tc;
            ArrayList<String> datosUsuario = new ArrayList<>();
            ArrayList<String> datosVehiculo = new ArrayList<>();
            String numTarjeta = "";
            int puntosLic = 0;
            Vehiculo auto = new Vehiculo();
            String[] elemento = linea.trim().split(",");
            String cedulaA = elemento[0];
            String[] nombresA = elemento[1].trim().split(" ");
            String nombreA = nombresA[0];
            String apellidoA = nombresA[1];
            int edadA = Integer.parseInt(elemento[2]);
            String correoA = elemento[3];
            String usuarioA = elemento[4];
            String contrasenaA = elemento[5];
            String perfilA = elemento[6];
            
            switch(perfilA){
                case "O":
                    p = Perfil.OPERADOR;
                    datosUsuario = ManejoArchivo.LeeFichero("operadores.txt");
                    double sueldo = 0;
                    for(String lineaO : datosUsuario){
                        String[] elementoO = lineaO.trim().split(",");
                        String cedulaO = elementoO[0];
                        if(cedulaO.equals(cedulaA))
                            sueldo = Double.parseDouble(elementoO[1]);
                    }
                    Usuario operador = new Operador(cedulaA, nombreA, apellidoA, edadA, correoA, usuarioA, contrasenaA, p, sueldo);
                    usuariosArray.add(operador);
                    break;
                    
                case "E":
                    p = Perfil.CLIENTE;
                    tc = TipoCliente.ESTRELLA;
                    datosUsuario = ManejoArchivo.LeeFichero("clientes.txt");
                    datosVehiculo = ManejoArchivo.LeeFichero("vehiculos.txt");
                    for(String lineaC : datosUsuario){
                        String[] elementoC = lineaC.trim().split(",");
                        String cedulaC = elementoC[0];
                        if(cedulaC.equals(cedulaA)){
                            numTarjeta = elementoC[1];
                            puntosLic = Integer.parseInt(elementoC[2]);
                        }
                    }
                    for(String lineaV : datosVehiculo){
                        String[] elementoV = lineaV.trim().split(",");
                        String cedulaV = elementoV[0];
                        String placa = elementoV[1];
                        String marca = elementoV[2];
                        String modelo = elementoV[3];
                        int anio = Integer.parseInt(elementoV[4]);
                        String chasis = elementoV[5];
                        String color = elementoV[6];
                        if(cedulaV.equals(cedulaA)){
                            auto = new Vehiculo(cedulaV, placa, marca, modelo, anio, chasis, color);
                        }
                    }
                    Usuario clienteEstrella = new Cliente(cedulaA, nombreA, apellidoA, edadA, correoA, usuarioA, contrasenaA, p, tc, numTarjeta, puntosLic, auto);
                    usuariosArray.add(clienteEstrella);
                    break;
                    
                case "S":
                    p = Perfil.CLIENTE;
                    tc = TipoCliente.ESTANDAR;
                    datosUsuario = ManejoArchivo.LeeFichero("clientes.txt");
                    datosVehiculo = ManejoArchivo.LeeFichero("vehiculos.txt");
                    for(String lineaC : datosUsuario){
                        String[] elementoC = lineaC.trim().split(",");
                        String cedulaC = elementoC[0];
                        if(cedulaC.equals(cedulaA)){
                            numTarjeta = elementoC[1];
                            puntosLic = Integer.parseInt(elementoC[2]);
                        }
                    }
                    for(String lineaV:datosVehiculo){
                        String[] elementoV = lineaV.trim().split(",");
                        String cedulaV = elementoV[0];
                        String placa = elementoV[1];
                        String marca = elementoV[2];
                        String modelo = elementoV[3];
                        int anio = Integer.parseInt(elementoV[4]);
                        String chasis = elementoV[5];
                        String color = elementoV[6];
                        if(cedulaV.equals(cedulaA)){
                            auto = new Vehiculo(cedulaV,placa,marca,modelo,anio,chasis,color);
                        }
                    }
                    Usuario clienteEstandar = new Cliente(cedulaA, nombreA, apellidoA, edadA, correoA, usuarioA, contrasenaA, p, tc, numTarjeta, puntosLic, auto);
                    usuariosArray.add(clienteEstandar);
                    break;
            }
        } 
        return usuariosArray;
    }
    
    /**
     * Comprueba si las credenciales de usuario son válidas.
     * @param user  el nombre de usuario
     * @param pass  la contraseña
     * @param lista la lista de usuarios
     * @return true si las credenciales son válidas, false en caso contrario
     */
    
    public static boolean comprobarUsuario(String user, String pass, ArrayList<Usuario> lista) {
        for (Usuario u : lista) {
            if (u.getUsuario().equals(user) && u.getContrasena().equals(pass)) {
                return true; // Usuario encontrado, retorna true
            }
        }
        return false; // Usuario no encontrado, retorna false
    }
    
    /**
     * Comprueba el tipo de usuario y realiza la acción correspondiente.
     * @param u el usuario
     */
    
    public static void comprobarTipo(Usuario u){
        if(u instanceof Cliente){
            Cliente cliente = (Cliente) u;
            cliente.opcionesMenu();
        } 
        else if (u instanceof Operador){
            Operador operador = (Operador)u;
            operador.opcionesMenu();
        }
    }
    
    /**
     * Verifica si una cadena de texto representa un número entero.
     * @param str la cadena de texto a verificar
     * @return true si la cadena es un número entero, false en caso contrario
     */
    
    public static boolean esEntero(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Verifica si un cliente está registrado en el sistema.
     * @param cedula el número de cédula del cliente
     * @return true si el cliente está registrado, false en caso contrario
     */
    
    public static boolean verificarCliente(String cedula){
        ArrayList<Usuario> lista=cargarUsuario();
        for (Usuario u: lista){
            if (cedula.equals(u.getCedula()) && u.getPerfil().equals(Perfil.CLIENTE)){
                return true;
            }
        }
        return false;
    }

}
