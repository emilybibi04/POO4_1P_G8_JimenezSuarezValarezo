/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

/**
 *
 * @author gabsy
 */
public class Vehiculo {
    private String placa; 
    private String marca;
    private String modelo;
    private int anio;
    private String chasis;
    private String color; 
    
   public Vehiculo(String placa, String marca, String modelo, int anio, String chasis, String color){
       this.placa = placa;
       this.marca = marca;
       this.modelo = modelo;
       this.anio = anio;
       this.chasis = chasis;
       this.color = color;
   
   }
   
   //Métodos gettes y setters para acceder a los métodos privados
   
   //placa
   public void setPlaca(String placa){
       this.placa = placa;
   }
   public String setPlaca(){
       return placa;
   }
   
   //Marca
   public void setMarca(String marca){
       this.marca = marca;
   }  
   public String getMarca(){
       return marca;
   }
   
   //modelo
   public void setModelo(String modelo){
       this.modelo = modelo;
   }
   
   public String getModelo(){
       return modelo;
   }
   
   //anio
   public void setAnio(int anio){
       this.anio = anio;
   }
   
   public int getAnio(){
       return anio;
   }
   
   //chasis
   public void setChasis(String chasis){
       this.chasis = chasis;
   }
   public String getChasis(){
       return chasis;
   }
   
   //color
   public void setColor(String color){
       this.color = color;
   }   
   public String getColor(){
       return color;
   }
   
   //sobreescritura método toString de 'Vehículo'.
   @Override
   public String toString(){
       return "Placa: "+placa+" | "+"Marca: "+marca+" | "+"Modelo: "+modelo+" | "+
               "Año: "+anio+" | "+"Chasis: "+chasis+" | "+"Color: "+color;
   }
}




