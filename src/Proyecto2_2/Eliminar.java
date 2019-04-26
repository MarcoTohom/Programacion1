package Proyecto2_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Eliminar {

    static void solicitarEliminarDemanda() {
        String nombreDemandante = JOptionPane.showInputDialog(null, "Ingrese nombre completo de demandante", "Ingreso", JOptionPane.QUESTION_MESSAGE);
        String nombreDemandado = JOptionPane.showInputDialog(null, "Ingrese nombre completo de demandante", "Ingreso", JOptionPane.QUESTION_MESSAGE);
        nombreDemandante = nombreDemandante.toLowerCase();
        nombreDemandado = nombreDemandado.toLowerCase();
        int numeroRegistro = Buscar.buscarDemanda(nombreDemandante, nombreDemandado);
        Eliminar.eliminarDemanda(numeroRegistro);
        JOptionPane.showMessageDialog(null, "Demanda eliminada", "Salida", JOptionPane.INFORMATION_MESSAGE);
    }

    static void eliminarDemanda(int pNumeroRegistro) {
        try {
            String stringPNumeroRegistro = String.valueOf(pNumeroRegistro).concat("#");
            FileOutputStream fos = new FileOutputStream("delete.txt", true);
            byte[] charPRegistro = stringPNumeroRegistro.getBytes();
            fos.write(charPRegistro);
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    static boolean consultarDemandaEliminada(int pNumeroRegistro) {
        String registro = "";
        int caracter = 0;
        boolean eliminado = false;
        
        String stringPNumeroRegistro = String.valueOf(pNumeroRegistro);
        try {
            InputStream is = new FileInputStream("delete.txt");
            while (caracter != -1) {
                caracter = is.read();
                String letra = String.valueOf((char)caracter);
                if ("#".equals(letra)) {
                    if (Integer.valueOf(registro) == pNumeroRegistro) {
                        eliminado = true;
                        break;
                    }
                    if (String.valueOf(pNumeroRegistro).equals(registro)) {
                        eliminado = true;
                        break;
                    }
                    registro = "";
                } else {
                    registro = registro.concat(letra);
                }
            }
            is.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return eliminado;
    }
}
