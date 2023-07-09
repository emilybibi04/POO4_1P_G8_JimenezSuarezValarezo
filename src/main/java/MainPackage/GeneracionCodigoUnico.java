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
    
    public GeneracionCodigoUnico() {
        generatedCodes = new HashSet<>();
        secureRandom = new SecureRandom();
    }
    
    public int generarCodigoUnico() {
        int code;
        do {
            code = secureRandom.nextInt(9000) + 1000;
        } while (!generatedCodes.add(code));
        
        return code;
    }
    
}
