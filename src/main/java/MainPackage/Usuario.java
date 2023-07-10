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

public abstract class Usuario{
    /**
     * cedula Cédula del usuario.
     */
    protected String cedula;
    /**
     * nombres Nombres del usuario.
     */
    protected String nombres;
    /**
     * apellidos Apellidos del usuario.
     */
    protected String apellidos;
    /**
     *edad Edad del usuario.
     */
    protected int edad;
    /**
     * correo Correo electrónico del usuario.
     */
    protected String correo;
    /**
     * usuario Nombre de usuario.
     */
    protected String usuario;
    /**
     * contrasena Contraseña del usuario.
     */
    protected String contrasena;
    /**
     * perfil Perfil del usuario.
     */
    protected Perfil perfil;
    
    /**
     * Constructor de la clase Usuario.
     * @param cedula Cédula del usuario.
     * @param nombres Nombres del usuario.
     * @param apellidos Apellidos del usuario.
     * @param edad Edad del usuario.
     * @param correo Correo electrónico del usuario.
     * @param usuario Nombre de usuario.
     * @param contrasena Contraseña del usuario.
     * @param perfil Perfil del usuario.
     */
    
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
    
    /**
     * Método getter que obtiene la cédula del usuario.
     * @return Cédula del usuario.
     */
    
    public String getCedula(){
        return cedula;
    }
    
    /**
     * Método setter que establece la cédula del usuario.
     * @param cedula Cédula del usuario.
     */
    
    public void setCedula(String cedula){
        this.cedula = cedula;
    }
    
    /**
     * Método getter que obtiene los nombres del usuario.
     * @return Nombres del usuario.
     */
    
    public String getNombres(){
        return nombres;
    }
    
    /**
     * Método setter que establece los nombres del usuario.
     * @param nombres Nombres del usuario.
     */
    
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    
    /**
     * Método getter que obtiene los apellidos del usuario.
     * @return Apellidos del usuario.
     */
    
    public String getApellidos(){
        return apellidos;
    }
    
    /**
     * Método setter que establece los apellidos del usuario.
     * @param apellidos Apellidos del usuario.
     */
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    /**
     * Método getter que obtiene la edad del usuario.
     * @return Edad del usuario.
     */
    
    public int getEdad(){
        return edad;
    }
    
    /**
     * Método setter que establece la edad del usuario.
     * @param edad Edad del usuario.
     */
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    /**
     * Método getter que obtiene el correo electrónico del usuario.
     * @return Correo electrónico del usuario.
     */
    
    public String getCorreo(){
        return correo;
    }
    
    /**
     * Método setter que establece el correo electrónico del usuario.
     * @param correo Correo electrónico del usuario.
     */
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    /**
     * Método getter que obtiene el nombre de usuario.
     * @return Nombre de usuario.
     */
    
    public String getUsuario(){
        return usuario;
    }
    
    /**
     * Método setter que establece el nombre de usuario.
     * @param usuario Nombre de usuario.
     */
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    /**
     * Método getter que obtiene la contraseña del usuario.
     * @return Contraseña del usuario.
     */
    
    public String getContrasena(){
        return contrasena;
    }
    
    /**
     * Método setter que establece la contraseña del usuario.
     * @param contrasena Contraseña del usuario.
     */
    
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
    
    /**
     * Método getter que obtiene el perfil del usuario.
     * @return Perfil del usuario.
     */
    
    public Perfil getPerfil(){
        return perfil;
    }
    
    /**
     * Método setter que establece el perfil del usuario.
     * @param perfil Perfil del usuario.
     */
    
    public void sePerfil(Perfil perfil){
        this.perfil = perfil;
    }
    
    /**
     * Devuelve una representación en forma de cadena del usuario.
     * @return Cadena que representa al usuario.
     */
    
    @Override
    public String toString(){
        return cedula + nombres + apellidos + edad + correo + usuario + contrasena + perfil;
    }
    
    /**
     * Método abstracto para mostrar las opciones de menú disponibles para el usuario.
     */
    public abstract void opcionesMenu();
    
    /**
     * Método abstracto para consultar las multas del usuario.
     */
    public abstract void consultarMultas();
}