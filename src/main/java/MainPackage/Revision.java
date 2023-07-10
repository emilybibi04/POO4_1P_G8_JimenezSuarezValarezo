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

    public Revision(){
    }

    public Revision(String codigoHash,String cedula,String matricula,String fecha){
        this.codigoHash=codigoHash;
        this.cedula=cedula;
        this.matricula=matricula;
        this.fecha=fecha;
    }

    public String getFecha(){
        return fecha;
    }
    
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

    public double valorRevision(Cliente c){
        double base = 150;
        double valorPagar = 0;

        //verificar el tipo de cliente que es
        if(c.getTipo() == TipoCliente.ESTRELLA)
            valorPagar = 120;
        else if(c.getTipo() == TipoCliente.ESTANDAR){
            ArrayList<String> listaMultas=ManejoArchivo.LeeFichero("multas.txt");
            int puntosPerdidos=0;
            for(String linea:listaMultas){
                String[] datos=linea.trim().split(",");
                if(datos[0].equals(c.getCedula()))
                    puntosPerdidos=Integer.parseInt(datos[6]);
            }
            valorPagar=base+(puntosPerdidos*10);
        }
        return valorPagar;
    }

    public String getMatricula(){
        return matricula;
    }
}
