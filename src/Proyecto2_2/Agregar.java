package Proyecto2_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Agregar {

    static void solicitarAgregarDemanda() {
        String nombreDemandante = "", nombreDemandado = "", direccionDemandado = "", registro = "";
        int montoPension = -1;
        nombreDemandante = JOptionPane.showInputDialog("\nIngrese nombre de demandante:\n");
        nombreDemandado = JOptionPane.showInputDialog("\nIngrese nombre de demandado:\n");
        //Se valida de que no esté inscrita la demanda
        if (Buscar.buscarDemanda(nombreDemandante) != -1 && Buscar.buscarDemanda(nombreDemandado) != -1 && Buscar.buscarDemanda(nombreDemandante) == Buscar.buscarDemanda(nombreDemandado)) {
            JOptionPane.showMessageDialog(null, "\nLa demanda ya está registrada en la base de datos.\n");
        } else {
            direccionDemandado = JOptionPane.showInputDialog("Ingrse direccion del demandado:");
            montoPension = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto de la pension:"));
            registro = registro.concat(nombreDemandante).concat("@").concat(nombreDemandado).concat("@").concat(direccionDemandado).concat("@").concat(String.valueOf(montoPension)).concat("@").concat("#");
            registro = registro.toLowerCase();
            agregarDemanda(registro);
        }
    }

    static void agregarDemanda(String pRegistro) {
        try {
            FileOutputStream fos = new FileOutputStream("OJDemandas.txt", true);
            byte[] charPRegistro = pRegistro.getBytes();
            fos.write(charPRegistro);
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "\nNo se ha podido encontrar la base de datos.\n");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "\nHa ocurrido un error al tratar de acceder a la base de datos\n");
        }
    }

    static void solicitarAgregarJuez() {
        String registro = "";
        int numeroColegiadoJuez = -1, numeroRegistro = -1;
        numeroRegistro = Buscar.solicitarBuscarDemanda();
        if (numeroRegistro != -1) {
            numeroRegistro = Buscar.buscarJuez(numeroRegistro, false);
            if (numeroRegistro != -1) {
                numeroColegiadoJuez = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de colegiado del juez:"));
                registro = registro.concat(String.valueOf(numeroRegistro)).concat("@").concat(String.valueOf(numeroColegiadoJuez).concat("@#"));
                Agregar.agregarDemanda(registro);
            } else {
                JOptionPane.showMessageDialog(null, "El juez ya se encuentra asignado", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    static void agregarJuez(String pRegistro) {
        try {
            FileOutputStream fos = new FileOutputStream("OJJueces.txt", true);
            byte[] charPRegistro = pRegistro.getBytes();
            fos.write(charPRegistro);
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "\nNo se ha podido encontrar la base de datos.\n");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "\nHa ocurrido un error al tratar de acceder a la base de datos\n");
        }
    }
}
