/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import EnumPackage.Perfil;


/**
 *
 * @author emilyvalarezo
 */
public class Usuario{
    
    private String cedula;
    private String nombres;
    private String apellidos;
    private int edad;
    private String correo;
    private String usuario;
    private String contrasena;
    private Perfil perfil;
    
    public Usuario (String cedula, String nombres, String apellidos, int edad, String correo, String usuario, String contrasena, Perfil perfil){
        
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.perfil = perfil;
    }
    
    public String getCedula(){
        return cedula;
    }
    
    public void setCedula(String cedula){
        this.cedula = cedula;
    }
    
    public String getNombres(){
        return nombres;
    }
    
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getContrasena(){
        return contrasena;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
    
    public Perfil getPerfil(){
        return perfil;
    }
    
    public void sePerfil(Perfil perfil){
        this.perfil = perfil;
    }
    
    @Override
    public String toString(){
        return cedula + nombres + apellidos + edad + correo + usuario + contrasena + perfil;
    }
        
}
