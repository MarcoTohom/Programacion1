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
 *
 * @author Marco Antonio Lares Tohom
 */
public class AgregarEvento {

    static void agregarEvento(Date pFechaEvento, String pArtista, int pCantidadAsistentes) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("eventos.bin", true));
            dos.writeUTF(pFechaEvento.toString());
            dos.writeUTF(pArtista);
            dos.writeInt(pCantidadAsistentes);
            dos.close();
            cantidadEventos(false);
            System.out.println("escritura con exito");
        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        }
    }

    static int cantidadEventos(boolean consultar) {
        int cantidadRegistros = 0;
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("cantidadRegistros.bin"));
            System.out.println("*****");
            cantidadRegistros = dis.readInt();
            dis.close();
            if (!consultar) {
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("cantidadRegistros.bin"));
                dos.writeInt(cantidadRegistros+1);
                System.out.println(cantidadRegistros);
                dos.close();
            }

        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "FileNotFoundException");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "IOException");
        }
        return cantidadRegistros;
    }
}
