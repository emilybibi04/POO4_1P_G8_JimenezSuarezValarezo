/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MainPackage;
import java.util.Date;

/**
 *
 * @author gabsy
 */

public class Multa {
    
    //valores de instancia de la clase
    private Cliente cliente; 
    private String infraccion; 
    private double valorMulta;
    private Date fechaIfraccion;
    private Date fechaNotificacion;
    private int puntosPerdidos;

    
    //getters y setters de los valores de instancia
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(String infraccion) {
        this.infraccion = infraccion;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public Date getFechaIfraccion() {
        return fechaIfraccion;
    }

    public void setFechaIfraccion(Date fechaIfraccion) {
        this.fechaIfraccion = fechaIfraccion;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public int getPuntosPerdidos() {
        return puntosPerdidos;
    }

    public void setPuntosPerdidos(int puntosPerdidos) {
        this.puntosPerdidos = puntosPerdidos;
    }
    
}