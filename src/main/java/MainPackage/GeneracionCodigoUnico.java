/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gabsy
 */


public class GeneracionCodigoUnico {
    
    private Set<Integer> generatedCodes;
    private SecureRandom secureRandom;
    
    /**
     * Constructor de la clase GeneracionCodigoUnico.
     */
    
    public GeneracionCodigoUnico() {
        generatedCodes = new HashSet<>();
        secureRandom = new SecureRandom();
    }
    
    /**
     * Método que genera un código único por medio del uso de Random.
     * El código generado se asegura de no estar repetido en los códigos generados previamente.
     * @return Código único generado.
     */
    
    public int generarCodigoUnico() {
        int code;
        do {
            code = secureRandom.nextInt(9000) + 1000;
        } while (!generatedCodes.add(code));
        
        return code;
    }
    
}
