package Proyecto3;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class AgregarNoGrafico {
    static void solicitarAgregarEvento() {
        String fecha = JOptionPane.showInputDialog("Ingrese la fecha:");
        int hora = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora:"));
        String artista = JOptionPane.showInputDialog("Ingrese nombre del artista:");
        int totalAsistentes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de asistentes:"));
        AgregarNoGrafico.agregarEvento(fecha, hora, artista, totalAsistentes);
    }
    static void agregarEvento(String pFecha, int pHora, String pArtista, int pTotalAsistentes) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("eventos.bin", Boolean.TRUE));
            dos.writeUTF(pFecha);
            dos.writeInt(pHora);
            dos.writeUTF(pArtista);
            dos.writeInt(pTotalAsistentes);
            dos.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la base de datos.");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la conexión a la base de datos.");
        }
    }
}
