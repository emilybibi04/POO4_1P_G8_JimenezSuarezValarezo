/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import EnumPackage.TipoPago;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.swing.JOptionPane;

import EnumPackage.TipoPago;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author davidsuarez
 */
public class Pagos {
    private String codigoPago;
    private String cedula;
    private double valorPagar;
    private TipoPago tipo;
    private double valorFinalPagar;
    private LocalDate fechaPago;
    private String razonPago;
    
    public Pagos(String codigoPago, String cedula, double valorPagar, TipoPago tipo, double valorFinalPagar, String razonPago){
        this.codigoPago=codigoPago;
        this.cedula=cedula;
        this.valorPagar=valorPagar;
        this.tipo=tipo;
        this.valorFinalPagar=valorFinalPagar;
        this.fechaPago=LocalDate.now();
        this.razonPago=razonPago;
    }
    
    public void registrarPagos(){
        try{
                File f = new File("pagos.txt");
                FileWriter fw = new FileWriter(f,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                //para escribir los datos del horario en el archivo
                String fecha=String.valueOf(fechaPago.getDayOfMonth())+"-"+String.valueOf(fechaPago.getMonthValue())+"-"+String.valueOf(fechaPago.getYear());
                String pago=codigoPago+","+cedula+","+String.valueOf(valorPagar)+","+String.valueOf(tipo)+","+String.valueOf(valorFinalPagar)+","+fecha+","+razonPago;
                pw.println(pago);

                pw.close();
                bw.close();
                fw.close();
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "ha sucedido un error"+e);
            }
    }
}
