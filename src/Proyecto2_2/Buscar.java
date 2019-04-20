package Proyecto2_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Buscar {

    static int solicitarBuscarDemanda() {
        String terminoDeBusqueda = "";
        int numeroRegistro = 0;
        
        terminoDeBusqueda = JOptionPane.showInputDialog(null, "Ingrese nombre completo de demandante o demandado", "Ingreso", JOptionPane.QUESTION_MESSAGE);
        terminoDeBusqueda = terminoDeBusqueda.toLowerCase();

        numeroRegistro = Buscar.buscarDemanda(terminoDeBusqueda);

        return numeroRegistro;
    }

    static int buscarDemanda(String pTerminoDeBusqueda) {
        String registro = "";
        int numeroRegistro = 0, caracter = 0;
        boolean encontrado = false;

        pTerminoDeBusqueda = pTerminoDeBusqueda.toLowerCase();

        try {
            InputStream is = new FileInputStream("OJDemandas.txt");
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    registro = registro.toLowerCase();
                    if (registro.contains(pTerminoDeBusqueda)) {
                        encontrado = true;
                        break;
                    }
                    registro = "";
                    numeroRegistro++;
                } else {
                    registro = registro.concat(String.valueOf((char) caracter));
                }
            }
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "\nNo se ha podido encontrar la base de datos.\n");
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "\nHa ocurrido un error al tratar de acceder a la base de datos\n");
        }
        if (!encontrado) {
            numeroRegistro = -1;
        }
        return numeroRegistro;
    }

    static int solicitarBuscarJuez() {
        int numeroRegistro = -1, numeroColegiadoJuez;
        numeroColegiadoJuez = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de colegiado del juez", "Ingreso", JOptionPane.QUESTION_MESSAGE));
        numeroRegistro = Buscar.buscarJuez(numeroColegiadoJuez, true);
        return numeroRegistro;
    }

    static int buscarJuez(int pTerminoDeBusqueda, boolean tipoBusqueda) {
        String registro = "";
        int numeroRegistro = -1, busquedaNumeroDemandaColegiadoJuez = -1, caracter = 0;
        boolean encontrado = false;
            //Según el tipo de búsqueda se buscará si ya está asignada la demanda o se buscará el juez
        if (tipoBusqueda) {
            busquedaNumeroDemandaColegiadoJuez = 1; //Si es verdadero buscará por numero de colegiado
        } else {
            busquedaNumeroDemandaColegiadoJuez = 0; //Si es falso buscará por número de demanda
        }
        
        try {
            InputStream is = new FileInputStream("OJJueces.txt");
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    String vectorRegistro[] = registro.split("[^0-9]");
                    if (pTerminoDeBusqueda == Integer.parseInt(vectorRegistro[busquedaNumeroDemandaColegiadoJuez])) {
                        encontrado = true;
                        break;
                    }
                    registro = "";
                    numeroRegistro++;
                } else {
                    registro = registro.concat(String.valueOf((char) caracter));
                }
            }
            is.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "\nNo se ha podido encontrar la base de datos.\n");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "\nHa ocurrido un error al tratar de acceder a la base de datos\n");
        }
        if (!encontrado) {
            numeroRegistro = -1;
        }
        
        return numeroRegistro;
    }

    static int buscarVeredicto(int pNumeroRegistro) {
        int numeroRegistro = 0;

        return numeroRegistro;
    }
}
