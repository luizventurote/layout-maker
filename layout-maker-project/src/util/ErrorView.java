package util;

import javax.swing.JOptionPane;

public class ErrorView {
    
    /**
     * Error default.
     * 
     * @param error 
     */
    public static void errorDefault(Exception error) {
        JOptionPane.showMessageDialog(null, "ERRO não esperado. " + error.getMessage() );
    }
    
}
