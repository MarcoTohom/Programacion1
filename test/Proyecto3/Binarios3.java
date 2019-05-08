package Proyecto3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Binarios3 {
    public static void main(String[] args) {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("datos.dat"));
            Integer numero = 0;
            Byte data = dis.readByte();
            numero = data.intValue();
            while (numero >= -1) {
                JOptionPane.showMessageDialog(null, numero);
                data = dis.readByte();
                numero = data.intValue();
            }
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, fnfe.getMessage());
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe.getMessage());
        }
    }
}
