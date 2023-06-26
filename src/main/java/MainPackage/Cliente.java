/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import EnumPackage.TipoCliente;
import EnumPackage.Perfil;


/**
 *
 * @author gabsy
 */

//Creación de clase 'Cliente que hereda de 'Usuario' para hacer uso de sus atributos y sobreescribir sus métodos. 
public class Cliente extends Usuario {
    //Atributos de instancia de la clase 'Cliente'   
    private TipoCliente tipo; 
    private int numTarjetaCred;
    private int puntosLicencia; 
    private Vehiculo vehiculo;
    
    public Cliente(String cedula, String nombres, String apellidos, int edad, String correo, String usuario, String contrasena, Perfil perfil, TipoCliente tipo, int numTarjetaCred, int puntosLicencia, Vehiculo vehiculo){
        //invocación del constructor de la clase padre
        super(cedula, nombres, apellidos, edad, correo, usuario, contrasena, perfil);
        
        this.tipo = tipo;
        this.numTarjetaCred = numTarjetaCred;
        this.puntosLicencia = puntosLicencia;
        this.vehiculo = vehiculo;
    
    }
    
    //Sobreescritura del método toString()
    public String toString(){
        return "Tipo de cliente: "+ tipo +"/nPuntos de Licencia: "+ puntosLicencia+ "/nVehiculo:/n"+ vehiculo.toString();
    }
}
