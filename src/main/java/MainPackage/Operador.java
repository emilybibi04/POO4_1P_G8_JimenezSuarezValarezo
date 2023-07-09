/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import EnumPackage.Perfil;

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
     }
     
     @Override
     public void opcionesMenu(){
         System.out.println("pipi");
     }
}
