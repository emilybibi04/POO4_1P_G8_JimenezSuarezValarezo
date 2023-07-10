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
    private String cedula;
    private String placa; 
    private String marca;
    private String modelo;
    private int anio;
    private String chasis;
    private String color; 
    
    /**
     * Constructor por defecto de la clase Vehiculo.
     */
    
    public Vehiculo(){}
    
    /**
     * Constructor de la clase Vehiculo.
     * @param cedula Cédula del propietario del vehículo.
     * @param placa Placa del vehículo.
     * @param marca Marca del vehículo.
     * @param modelo Modelo del vehículo.
     * @param anio Año de fabricación del vehículo.
     * @param chasis Número de chasis del vehículo.
     * @param color Color del vehículo.
     */
    
    public Vehiculo(String cedula, String placa, String marca, String modelo, int anio, String chasis, String color){
       this.cedula = cedula;
       this.placa = placa;
       this.marca = marca;
       this.modelo = modelo;
       this.anio = anio;
       this.chasis = chasis;
       this.color = color;
   
   }
   
   //Métodos gettes y setters para acceder a los métodos privados
    
    /**
     * Método getter que obtiene la cédula del propietario del vehículo.
     * @return Cédula del propietario del vehículo.
     */
    
    public String getCedula(){
        return cedula;
    }
    
    //placa
    
    /**
     * Método setter que establece la placa del vehículo.
     * @param placa Placa del vehículo.
     */
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    /**
     * Método getter que obtiene la placa del vehículo.
     * @return Placa del vehículo.
     */
    
    public String getPlaca(){
        return placa;
    }

    //Marca
    
    /**
     * Método setter que establece la marca del vehículo.
     * @param marca Marca del vehículo.
     */
    
    public void setMarca(String marca){
        this.marca = marca;
    }  
    
    /**
     * Método getter que obtiene la marca del vehículo.
     * @return Marca del vehículo.
     */
    
    public String getMarca(){
        return marca;
    }

    //modelo
    
    /**
     * Método setter que establece el modelo del vehículo.
     * @param modelo Modelo del vehículo.
     */
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    /**
     * Método getter que obtiene el modelo del vehículo.
     * @return Modelo del vehículo.
     */
    
    public String getModelo(){
        return modelo;
    }

    //anio
    
    /**
     * Método setter que establece el año de fabricación del vehículo.
     * @param anio Año de fabricación del vehículo.
     */
    
    public void setAnio(int anio){
        this.anio = anio;
    }

    /**
     * Método getter que obtiene el año de fabricación del vehículo.
     * @return Año de fabricación del vehículo.
     */
    
    public int getAnio(){
        return anio;
    }

    //chasis
    
    /**
     * Método setter que establece el número de chasis del vehículo.
     * @param chasis Número de chasis del vehículo.
     */
    
    public void setChasis(String chasis){
        this.chasis = chasis;
    }
    
    /**
     * Método getter que obtiene el número de chasis del vehículo.
     * @return Número de chasis del vehículo.
     */
    
    public String getChasis(){
        return chasis;
    }

    //color
    
    /**
     * Método setter que establece el color del vehículo.
     * @param color Color del vehículo.
     */
    
    public void setColor(String color){
        this.color = color;
    }   
    
    /**
     * Método getter que obtiene el color del vehículo.
     * @return Color del vehículo.
     */
    
    public String getColor(){
        return color;
    }

    /**
     * Sobreescritura del método toString de Vehículo.
     * Devuelve una representación en forma de cadena del vehículo.
     * @return Cadena que representa al vehículo.
     */
    
    @Override
    public String toString(){
        return "Placa: " + placa + " | Marca: " + marca + " | Modelo: " + modelo + " | Año: " + anio + " | Chasis: " + chasis + " | Color: " + color;
    }
 }