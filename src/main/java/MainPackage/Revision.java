/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import EnumPackage.TipoCliente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author davidsuarez
 */
public class Revision {
    private String codigoHash;
    private String cedula;
    private String matricula;
    private String fecha;

    /**
     * Constructor por defecto de la clase Revision.
     */
    
    public Revision(){
    }

    
    /**
     * Constructor de la clase Revision.
     * @param codigoHash Código hash de la revisión.
     * @param cedula Cédula del cliente asociado a la revisión.
     * @param matricula Matrícula del vehículo asociado a la revisión.
     * @param fecha Fecha de la revisión.
     */
    
    public Revision(String codigoHash,String cedula,String matricula,String fecha){
        this.codigoHash=codigoHash;
        this.cedula=cedula;
        this.matricula=matricula;
        this.fecha=fecha;
    }

    /**
     * Método getter que obtiene la fecha de la revisión.
     * @return Fecha de la revisión.
     */
    
    public String getFecha(){
        return fecha;
    }
    
    /**
     * Método que registra la revisión en un archivo.
     * @param revision Datos de la revisión a registrar.
     */
    
    public void registrarRevision(String revision){
        try{
                File f = new File("CitasAgendadas.txt");
                FileWriter fw = new FileWriter(f,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                //para escribir los datos del horario en el archivo
                pw.println(revision);

                pw.close();
                bw.close();
                fw.close();
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "ha sucedido un error"+e);
            }
    }

    /**
     * Método que calcula el valor a pagar por la revisión según el tipo de cliente.
     * @param c Cliente asociado a la revisión.
     * @return Valor a pagar por la revisión.
     */
    
    public double valorRevision(Cliente c){
        double base = 150;
        double valorPagar = 0;

        //verificar el tipo de cliente que es
        if(c.getTipo() == TipoCliente.ESTRELLA)
            valorPagar = 120;
        else if(c.getTipo() == TipoCliente.ESTANDAR){
            ArrayList<String> listaClientes=ManejoArchivo.LeeFichero("clientes.txt");
            int puntosPerdidos=0;
            for(String linea:listaClientes){
                String[] datos=linea.trim().split(",");
                if(datos[0].equals(c.getCedula()))
                    puntosPerdidos=30-Integer.parseInt(datos[2]);
            }
            valorPagar=base+(puntosPerdidos*10);
        }
        return valorPagar;
    }

    /**
     * Método getter que obtiene la matrícula del vehículo asociado a la revisión.
     * @return Matrícula del vehículo asociado a la revisión.
     */
    
    public String getMatricula(){
        return matricula;
    }
}
