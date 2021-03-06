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
            int numeroRegistro = Buscar.buscarDemanda(nombreDemandante, nombreDemandado);
            boolean demandaEliminada= Eliminar.consultarDemandaEliminada(numeroRegistro);
            if ((numeroRegistro != -1 && demandaEliminada) || numeroRegistro == -1) {
                direccionDemandado = JOptionPane.showInputDialog("Ingrse direccion del demandado:");
                montoPension = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto de la pension:"));
                registro = registro.concat(nombreDemandante).concat("@").concat(nombreDemandado).concat("@").concat(direccionDemandado).concat("@").concat(String.valueOf(montoPension)).concat("@").concat("#");
                registro = registro.toLowerCase();
                agregarDemanda(registro);
            } else {
                JOptionPane.showMessageDialog(null, "\nLa demanda ya está registrada en la base de datos.\n");
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
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    static void solicitarAgregarJuez() {
        String registro = "";
        int numeroColegiadoJuez = -1, numeroRegistroDemanda = -1, numeroRegistroJuez = -1;
        numeroRegistroDemanda = Buscar.solicitarBuscarDemanda();
        if (numeroRegistroDemanda != -1) { //Si está la demanda
            numeroRegistroJuez = Buscar.buscarJuez(numeroRegistroDemanda, false);
            if (numeroRegistroJuez == -1) {
                numeroColegiadoJuez = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de colegiado del juez:"));
                registro = registro.concat(String.valueOf(numeroRegistroDemanda)).concat("@").concat(String.valueOf(numeroColegiadoJuez).concat("@#"));
                Agregar.agregarJuez(registro);
            } else {
                JOptionPane.showMessageDialog(null, "El juez ya se encuentra asignado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    static void agregarJuez(String pRegistro) {
        try {
            FileOutputStream fos = new FileOutputStream("OJJueces.txt", true);
            byte[] charPRegistro = pRegistro.getBytes();
            fos.write(charPRegistro);
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    static void solicitarAgregarVeredicto() {
        String registro = "";
        int numeroRegistroDemanda = -1, numeroRegistroJuez = -1, numeroRegistroVeredicto = -1, veredicto = 0;
        numeroRegistroDemanda = Buscar.solicitarBuscarDemanda(); //Se busca el numero de registro de la demanda en las demandas
        if (numeroRegistroDemanda != -1) { //Si es -1 no existe la demanda
            numeroRegistroJuez = Buscar.buscarJuez(numeroRegistroDemanda, false); //Se busca el numero de registro de la demanda en los jueces
            if (numeroRegistroJuez != -1) { //Si es -1 no existe juez asignado
                numeroRegistroVeredicto = Buscar.buscarVeredicto(numeroRegistroDemanda); //Se busca el numero de registro de la demanda en los veredictos
                if (numeroRegistroVeredicto == -1) { //Si es -1 no existe veredicto asignado
                    veredicto = JOptionPane.showConfirmDialog(null, "¿Ganó la demanda?", "Ingreso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (veredicto != -1) {
                        registro = registro.concat(String.valueOf(numeroRegistroDemanda) + "@" + String.valueOf(veredicto) + "@#");
                        Agregar.agregarVeredicto(registro);
                        JOptionPane.showMessageDialog(null, "Veredicto asignado", "Salida", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingreso erroneo", "Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
