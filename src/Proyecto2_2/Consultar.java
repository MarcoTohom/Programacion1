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
        String nombreDemandante = "", nombreDemandado = "";
        nombreDemandante = JOptionPane.showInputDialog(null, "Ingrese nombre completo del demandante", "Ingreso", JOptionPane.INFORMATION_MESSAGE);
        nombreDemandado = JOptionPane.showInputDialog(null, "Ingrese nombre completo del demandado", "Ingreso", JOptionPane.INFORMATION_MESSAGE);
        Consultar.consultarDemanda(nombreDemandante, nombreDemandado);
    }

    static String consultarDemanda(String pNombreDemandante, String pNombreDemandado) {
        //Declaracion de variables
        String registro = "";
        int numeroRegistro = -1, caracter = 0;
        boolean encontrado = true;
        //Se hace la busqueda en minusculas
        pNombreDemandante = pNombreDemandante.toLowerCase();
        try {
            InputStream is = new FileInputStream("OJDemandas.txt");
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    numeroRegistro++;
                    registro = registro.toLowerCase();
                    String[] campo = registro.split("[@]");
                    if (campo[0].contains(pNombreDemandante) && campo[1].contains(pNombreDemandado)) {
                        String registroJuez = Consultar.consultarJuez(numeroRegistro);
                        if (!("empty".equals(registroJuez))) {
                            String[] campoJuez = registroJuez.split("[@]");
                            registro.concat(campoJuez[1] + "@");
                            JOptionPane.showMessageDialog(null, registro);
                        }
                        encontrado = true;
                        break;
                    }
                    registro = "";
                } else {
                    registro = registro.concat(stringCaracter);
                }
            }
            is.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return registro;
    }

    static String consultarJuez(int pNumeroRegistro) {
        String registro = "";
        int caracter = 0;
        boolean encontrado = true;
        try {
            InputStream is = new FileInputStream("OJJueces.txt");
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    registro = registro.toLowerCase();
                    String campo[] = registro.split("[@]");
                    //Prueba
                    /*for (int i = 0; i < campo.length; i++) {
                        System.out.println(campo[i]);
                    }*/
                    if (Integer.parseInt(campo[0]) == pNumeroRegistro) {
                        registro = campo[1];
                        encontrado = true;
                        break;
                    }
                    registro = "";
                } else {
                    registro = registro.concat(stringCaracter);
                }
            }
            is.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if (!encontrado) {
            registro = "empty";
        }
        return registro;
    }

    static String consultarGeneral() {
        String registro = "empty";

        return registro;
    }
}
