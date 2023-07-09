/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MainPackage;
import java.util.ArrayList;
import java.util.Scanner;
import EnumPackage.TipoCliente;
import EnumPackage.Perfil;
/**
 *
 * @author emilyvalarezo
 */
public class SistemaVehicular {
    
    static ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();

    public static void main(String[] args){
        //ejecutar();
        Vehiculo v = new Vehiculo("0923879161","GBV9034","CHEVROLET","ELANTRA",2018,"HWIK3457MSSJ083723","BLANCO");
        Usuario cl = new Cliente("0972327367","Carolina", "Sabando",23,"csabando@gmail.com","csabando","dkioeiw2",Perfil.CLIENTE, TipoCliente.ESTRELLA, "538283736926233",25,v);
        cl.consultarMultas();
    }
    
    public static void ejecutar(){
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