package Proyecto3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Test {
    public static void main(String[] args) {
        String opcion = JOptionPane.showInputDialog("Nombre de clase y funcion");
        switch(opcion) {
            case "inicializarCantidadRegistros":
                inicializarCantidadRegistros();
                break;
            case "cantidadEventos":
                testCantidadEventos();
                break;
            default:
                System.err.println("Opcion incorrecta");
        }
    }
    static void inicializarCantidadRegistros(){
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("cantidadRegistros.bin"));
            dos.writeInt(0);
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "FileNotFoundException");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "IOException");
        }
    }
    static void testCantidadEventos() {
        AgregarEvento.cantidadEventos(false);
    }
}
