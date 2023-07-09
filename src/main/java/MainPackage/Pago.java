/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MainPackage;

//se importa los paquetes necesarios
import java.util.Date;
import EnumPackage.TipoPago;
import EnumPackage.RazonPago;

/**
 *
 * @author gabsy
 */

public class Pago {
    
    //variables de instancia
    private double codigoPago;
    private Cliente cliente;
    private double valorPagar;
    private double valorFinalPagar;
    private Date fechaPago;
    private TipoPago tipoPago;
    private RazonPago razonPago;
    private final int pago = 150;

    
    //getters y setters
    public double getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(double codigoPago) {
        this.codigoPago = codigoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public double getValorFinalPagar() {
        return valorFinalPagar;
    }

    public void setValorFinalPagar(double valorFinalPagar) {
        this.valorFinalPagar = valorFinalPagar;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public RazonPago getRazonPago() {
        return razonPago;
    }

    public void setRazonPago(RazonPago razonPago) {
        this.razonPago = razonPago;
    }

    //métodos
    
    public void pagoMulta(){}
    
    public void pagoRevision(){}
}