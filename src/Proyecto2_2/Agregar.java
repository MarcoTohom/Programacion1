package Proyecto2_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Agregar {

    static void solicitarAgregarDemanda() {
        try {
            String nombreDemandante = "", nombreDemandado = "", direccionDemandado = "", registro = "";
            int montoPension = -1;
            nombreDemandante = JOptionPane.showInputDialog("\nIngrese nombre de demandante:\n");
            nombreDemandado = JOptionPane.showInputDialog("\nIngrese nombre de demandado:\n");
            //Se valida de que no esté inscrita la demanda
            if (Buscar.buscarDemanda(nombreDemandante, nombreDemandado) != -1) {
                JOptionPane.showMessageDialog(null, "\nLa demanda ya está registrada en la base de datos.\n");
            } else {
                direccionDemandado = JOptionPane.showInputDialog("Ingrse direccion del demandado:");
                montoPension = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto de la pension:"));
                registro = registro.concat(nombreDemandante).concat("@").concat(nombreDemandado).concat("@").concat(direccionDemandado).concat("@").concat(String.valueOf(montoPension)).concat("@").concat("#");
                registro = registro.toLowerCase();
                agregarDemanda(registro);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Se ha ingresado un valor erróneo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    static void agregarDemanda(String pRegistro) {
        try {
            FileOutputStream fos = new FileOutputStream("OJDemandas.txt", true);
            byte[] charPRegistro = pRegistro.getBytes();
            fos.write(charPRegistro);
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    static void solicitarAgregarVeredicto() {
        String registro = "";
        int numeroRegistro = -1, veredicto = 0;
        numeroRegistro = Buscar.solicitarBuscarDemanda(); //Se busca el numero de registro de la demanda en las demandas
        if (numeroRegistro != -1) { //Si es -1 no existe la demanda
            numeroRegistro = Buscar.buscarJuez(numeroRegistro, false); //Se busca el numero de registro de la demanda en los jueces
            if (numeroRegistro != -1) { //Si es -1 no existe juez asignado
                numeroRegistro = Buscar.buscarVeredicto(numeroRegistro); //Se busca el numero de registro de la demanda en los veredictos
                if (numeroRegistro != -1) { //Si es -1 no existe veredicto asignado
                    veredicto = JOptionPane.showConfirmDialog(null, "¿Ganó la demanda?", "Ingreso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (veredicto != -1) {
                        registro = registro.concat(String.valueOf(numeroRegistro) + "@" + String.valueOf(veredicto) + "@#");
                        Agregar.agregarVeredicto(registro);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingreso erroneo", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }

    static void agregarVeredicto(String pRegistro) {
        try {
            FileOutputStream fos = new FileOutputStream("OJVeredictos.txt", true);
            byte[] charPRegistro = pRegistro.getBytes();
            fos.write(charPRegistro);
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
