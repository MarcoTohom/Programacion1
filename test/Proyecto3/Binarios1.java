package Proyecto3;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Binarios1 {
    public static void main(String[] args) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.dat", true));
            int numero = 0;
            do {
                numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero positivo", "Ingreso", JOptionPane.PLAIN_MESSAGE));
                dos.write(numero);
            } while (numero > -1);
        } catch (FileNotFoundException fnfe) {
            
        } catch (IOException ioe) {
            
        }
    }
}
