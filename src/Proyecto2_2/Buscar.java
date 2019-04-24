package Proyecto2_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Buscar {

    static int solicitarBuscarDemanda() {
        String nombreDemandante = "", nombreDemandado = "";
        int numeroRegistro = 0;
        nombreDemandante = JOptionPane.showInputDialog(null, "Ingrese nombre completo de demandante", "Ingreso", JOptionPane.QUESTION_MESSAGE);
        nombreDemandado = JOptionPane.showInputDialog(null, "Ingrese nombre completo de demandante", "Ingreso", JOptionPane.QUESTION_MESSAGE);
        nombreDemandante = nombreDemandante.toLowerCase();
        nombreDemandado = nombreDemandado.toLowerCase();
        numeroRegistro = Buscar.buscarDemanda(nombreDemandante, nombreDemandado);
        return numeroRegistro;
    }

    static int buscarDemanda(String pNombreDemandante, String pNombreDemandado) {
        String registro = "";
        int numeroRegistro = 0, caracter = 0;
        boolean encontrado = false;
        pNombreDemandante = pNombreDemandante.toLowerCase();
        try {
            InputStream is = new FileInputStream("OJDemandas.txt");
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    numeroRegistro++;
                    registro = registro.toLowerCase();
                    String campo[] = registro.split("[@]");

                    if (campo[0].contains(pNombreDemandante) && campo[1].contains(pNombreDemandado)) {
                        encontrado = true;
                        break;
                    }
                    registro = "";
                } else {
                    registro = registro.concat(String.valueOf((char) caracter));
                }
            }
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
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
                    numeroRegistro++;
                    String vectorRegistro[] = registro.split("[^0-9]");
                    if (pTerminoDeBusqueda == Integer.parseInt(vectorRegistro[busquedaNumeroDemandaColegiadoJuez])) {
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
        if (!encontrado) {
            numeroRegistro = -1;
        }
        return numeroRegistro;
    }

    static int buscarVeredicto(int pNumeroRegistro) {
        String registro = "";
        int numeroRegistro = -1, caracter = 0;
        boolean encontrado = false;
        try {
            InputStream is = new FileInputStream("OJVeredictos.txt");
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    numeroRegistro++;
                    String vectorRegistro[] = registro.split("[^0-9]");
                    if (pNumeroRegistro == Integer.parseInt(vectorRegistro[0])) {
                        encontrado = true;
                        break;
                    }
                }
            }
            is.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if (!encontrado) {
            numeroRegistro = -1;
        }
        return numeroRegistro;
    }
}
