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

    static Scanner sc = new Scanner(System.in);

    static void solicitarAgregarDemanda() {
        String nombreDemandante = "", nombreDemandado = "", direccionDemandado = "", montoPension = "",
                registro = "";
        nombreDemandante = JOptionPane.showInputDialog("\nIngrese nombre de demandante:\n");
        nombreDemandado = JOptionPane.showInputDialog("\nIngrese nombre de demandado:\n");

        //Se valida de que no esté pre-inscrita la demanda
        if (Buscar.buscarDemanda(nombreDemandante) == Buscar.buscarDemanda(nombreDemandado)) {
            JOptionPane.showMessageDialog(null, "\nLa demanda ya está registrada en la base de datos.\n");
        } else {
            System.out.print("\nIngrse direccion del demandado: ");
            direccionDemandado = sc.nextLine();
            System.out.print("\nIngrese el monto de la pension: ");
            montoPension = sc.nextLine();
            registro = registro.concat(nombreDemandante).concat("…").concat(nombreDemandado).concat("…").concat(direccionDemandado).concat("…").concat(montoPension).concat("…").concat("Þ");
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
            System.err.print("\nNo se ha podido encontrar la base de datos.\n");
        } catch (IOException ioe) {
            System.err.print("\nHa ocurrido un error en la escritura/lectura.\n");
        }
    }

    static void solicitarAgregarJuez() {
        String registro = "";
        int lineaDemanda = 0, lineaJuez = 0, numeroColegiadoJuez;
        lineaDemanda = Buscar.solicitarBuscarDemanda();
        if (lineaDemanda != -1) {
            lineaJuez = Buscar.solicitarBuscarJuez();
            if (lineaJuez != -1) {
                numeroColegiadoJuez = Integer.parseInt(JOptionPane.showInputDialog("\nIngrese el numero de colegiado del juez\n"));
                
            } else {
                JOptionPane.showMessageDialog(null, "\nEl juez ya se encuentra asignado a la demanda\n");
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
