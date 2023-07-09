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
        System.out.println("     BIENVENIDO AL SISTEMA     ");
        System.out.println("+".repeat(32));
        System.out.println(" ");
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine(); 
    }
}