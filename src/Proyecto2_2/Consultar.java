package Proyecto2_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Consultar {

    static void solicitarConsultar() {
        try {
            String tipoConsulta = "";
            do {
                tipoConsulta = JOptionPane.showInputDialog(null, "Eliga el tipo de consulta:"
                        + "\n1. Por demanda"
                        + "\n2. General", "Ingreso", JOptionPane.INFORMATION_MESSAGE);
                switch (tipoConsulta) {
                    case "1":
                        Consultar.solicitarConsultarDemanda();
                        break;
                    case "2":
                        //Consultar.consultarGeneral
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                        tipoConsulta = "error";
                        break;
                }
            } while ("error".equals(tipoConsulta));
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    static void solicitarConsultarDemanda() {
        String terminoDeBusqueda = "";
        terminoDeBusqueda = JOptionPane.showInputDialog(null, "Ingrese nombre completo de demandante o demandado", "Ingreso", JOptionPane.INFORMATION_MESSAGE);
        Consultar.consultarDemanda(terminoDeBusqueda);
    }

    static void consultarDemanda(String pTerminoDeBusqueda) {
        //Declaracion de variables
        String registro = "";
        int numeroRegistro = -1, caracter = 0;
        boolean encontrado = true;
        //Se hace la busqueda en minusculas
        pTerminoDeBusqueda = pTerminoDeBusqueda.toLowerCase();
        try {
            InputStream is = new FileInputStream("OJDemandas");
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    numeroRegistro++;
                    registro = registro.toLowerCase();
                    if (registro.contains(pTerminoDeBusqueda)) {
                        encontrado = true;
                        break;
                    }
                    registro = "";
                } else {
                    registro = registro.concat(String.valueOf((char) caracter));
                }
            }
            is.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    static void consultarGeneral() {
        
    }
}
