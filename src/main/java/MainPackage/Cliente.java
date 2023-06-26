/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import EnumPackage.TipoCliente;
import MainPackage.Vehiculo;



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
    
    public Cliente(TipoCliente tipo, int numTarjetaCred, int puntosLicencia, Vehiculo vehiculo){
        this.tipo = tipo;
        this.numTarjetaCred = numTarjetaCred;
        this.puntosLicencia = puntosLicencia;
        this.vehiculo = vehiculo;
    
    }
}
