package Proyecto2_2;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Consultar {
    static File consultaPdf = new File("Consulta.pdf");
    static String direccion = consultaPdf.getAbsolutePath();
    static void solicitarConsultar() {
        try {
            String tipoConsulta = "";
            do {
                tipoConsulta = JOptionPane.showInputDialog(null, "Eliga el tipo de reporte:"
                        + "\n1. Por demanda"
                        + "\n2. General", "Ingreso", JOptionPane.QUESTION_MESSAGE);
                switch (tipoConsulta) {
                    case "1":
                        Consultar.solicitarConsultarDemanda();
                        break;
                    case "2":
                        Consultar.consultarGeneral();
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
        nombreDemandante = JOptionPane.showInputDialog(null, "Ingrese nombre completo del demandante", "Ingreso", JOptionPane.QUESTION_MESSAGE);
        nombreDemandado = JOptionPane.showInputDialog(null, "Ingrese nombre completo del demandado", "Ingreso", JOptionPane.QUESTION_MESSAGE);
        String registro = Consultar.consultarDemanda(nombreDemandante, nombreDemandado);
        if (registro.contains("empty")) {
            JOptionPane.showMessageDialog(null, "Verifique que los datos ingresados son correctos", "Demanda no encontrada", JOptionPane.QUESTION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Se ha creado la consulta.", "Listo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static String consultarDemanda(String pNombreDemandante, String pNombreDemandado) {
        //Declaracion de variables
        String registro = "";
        int numeroRegistro = -1, caracter = 0;
        boolean encontrado = false;
        //Se hace la busqueda en minusculas
        pNombreDemandante = pNombreDemandante.toLowerCase();
        pNombreDemandado = pNombreDemandado.toLowerCase();
        try {
            InputStream is = new FileInputStream("OJDemandas.txt");
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    numeroRegistro++;
                    if (!Eliminar.consultarDemandaEliminada(numeroRegistro)) {
                        registro = registro.toLowerCase();
                        String[] campoDemandas = registro.split("[@]");
                        if (campoDemandas[0].contains(pNombreDemandante) && campoDemandas[1].contains(pNombreDemandado)) {
                            String registroJuez = Consultar.consultarJuezVeredicto(numeroRegistro, true);
                            if (!("empty".equals(registroJuez))) {
                                registro = registro.concat(registroJuez + "@");
                                String registroVeredicto = Consultar.consultarJuezVeredicto(numeroRegistro, false);
                                if (!("empty".equals(registroVeredicto))) {
                                    registro = registro.concat(registroVeredicto + "@");
                                }
                            }
                            generarConsultaDemanda(registro);
                            encontrado = true;
                            break;
                        }
                    }
                    registro = "";
                } else {
                    registro = registro.concat(stringCaracter);
                }
            }
            is.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (!encontrado) {
            registro = "empty";
        }
        return registro;
    }

    static String consultarJuez(int pNumeroRegistro) {
        //<editor-fold defaultstate="collapsed" desc=" Consultar Juez antiguo ">
        String registro = "";
        int caracter = 0;
        boolean encontrado = false;
        try {
            InputStream is = new FileInputStream("OJJueces.txt");
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    registro = registro.toLowerCase();
                    String campo[] = registro.split("[@]");
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
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (!encontrado) {
            registro = "empty";
        }
        return registro;
        //</editor-fold>
    }

    static String consultarVeredicto(int pNumeroRegistro) {
        //<editor-fold defaultstate="collapsed" desc=" Consultar Veredicto antiguo ">
        String registro = "";
        int caracter = 0;
        boolean encontrado = true;
        try {
            InputStream is = new FileInputStream("OJVeredictos.txt");
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    registro = registro.toLowerCase();
                    String campo[] = registro.split("[@]");
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
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (!encontrado) {
            registro = "empty";
        }
        return registro;
        //</editor-fold>
    }

    static String consultarJuezVeredicto(int pNumeroRegistro, boolean juezVeredicto) {
        String registro = "", direccion = "";
        int caracter = 0;
        boolean encontrado = false;
        if (juezVeredicto) {
            direccion = "OJJueces.txt"; //Si es verdadero buscará en Jueces
        } else {
            direccion = "OJVeredictos.txt"; //Si es falso buscará en Veredictos
        }
        try {
            InputStream is = new FileInputStream(direccion);
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    registro = registro.toLowerCase();
                    String campo[] = registro.split("[^0-9]");
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
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (!encontrado) {
            registro = "empty";
        }
        return registro;
    }

    static void consultarGeneral() {
        try {
            PdfWriter pw = new PdfWriter("Consulta.pdf");
            PdfDocument pd = new PdfDocument(pw);
            Document doc = new Document(pd);
            String registro = "";
            int numeroRegistro = 0, cantidadDeRegistros = Consultar.cantidaDeRegistros(), montoTotalPension = 0;
            do {
                registro = Consultar.consultarDemanda(numeroRegistro);
                if (!(registro.contains("empty"))) {
                    registro = registro.toUpperCase();
                    String[] campo = registro.split("[@]");
                    campo[0] = campo[0].replaceAll("[^a-zA-Z ]", "");
                    montoTotalPension = montoTotalPension + Integer.parseInt(campo[3]);
                    String parrafo = "\nNumero de registro : "+ (numeroRegistro + 1) +"\nNombre de demandante: " + campo[0]
                            + "\nNombre de demandado: " + campo[1]
                            + "\nDireccion demandado: " + campo[2]
                            + "\nMonto pension: " + campo[3];
                    if (campo.length > 4) {
                        parrafo = parrafo.concat("\nColegiado de juez asignado: " + campo[4]);
                        if (campo.length > 5) {
                            String veredicto = "";
                            if (campo[5].equals("1")) {
                                veredicto = "Demanda ganada.";
                            } else {
                                veredicto = "Demanda no ganada.";
                            }
                            parrafo = parrafo.concat("\nVeredicto: "+veredicto+"\n");
                        }
                    }
                    doc.add(new Paragraph(parrafo));
                    //doc.add(new Paragraph("\n\n"));
                }
                numeroRegistro++;
            } while (numeroRegistro <= cantidadDeRegistros);
            doc.add(new Paragraph("Monto total de pensiones: "+montoTotalPension));
            JOptionPane.showMessageDialog(null, "Se ha creado la consulta en "+direccion, "Listo", JOptionPane.INFORMATION_MESSAGE);
            doc.close();
            pd.close();
            pw.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    static String consultarDemanda(int pNumeroRegistro) {
        String registro = "";
        int caracter = 0, numeroRegistro = -1;
        boolean encontrado = false;
        try {
            InputStream is = new FileInputStream("OJDemandas.txt");
            while (caracter != -1) {
                caracter = is.read();
                String stringCaracter = String.valueOf((char) caracter);
                if ("#".equals(stringCaracter)) {
                    numeroRegistro++;
                    if (!Eliminar.consultarDemandaEliminada(numeroRegistro)) {
                        if (numeroRegistro == pNumeroRegistro) {
                            String registroJuez = Consultar.consultarJuezVeredicto(numeroRegistro, true);
                            if (!("empty".equals(registroJuez))) {
                                registro = registro.concat(registroJuez + "@");
                                String registroVeredicto = Consultar.consultarJuezVeredicto(numeroRegistro, false);
                                if (!("empty".equals(registroVeredicto))) {
                                    registro = registro.concat(registroVeredicto + "@");
                                }
                            }
                            encontrado = true;
                            break;
                        }
                    }
                    registro = "";
                } else {
                    registro = registro.concat(stringCaracter);
                }
            }
            is.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (!encontrado) {
            registro = "empty";
        }
        return registro;
    }

    static void generarConsultaDemanda(String pRegistro) {
        pRegistro = pRegistro.toUpperCase();
        String[] campo = pRegistro.split("[@]");
        String veredicto;
        campo[0] = campo[0].replace("[^a-zA-Z ]", "");
        try {
            PdfWriter pw = new PdfWriter("Consulta.pdf");
            PdfDocument pd = new PdfDocument(pw);
            Document doc = new Document(pd);
            
            String parrafo = "\nNombre de demandante: " + campo[0]
                    + "\nNombre de demandado: " + campo[1]
                    + "\nDireccion demandado: " + campo[2]
                    + "\nMonto pension: " + campo[3];
            if (campo.length > 4) {
                parrafo = parrafo.concat("\nColegiado de juez: " + campo[4]);
                if (campo.length > 5) {
                    if (campo[5].equals("1")) {
                        veredicto = "Demanda ganada";
                    } else {
                        veredicto = "Demanda no ganada";
                    }
                    parrafo = parrafo.concat("\nVeredicto: "+ veredicto);
                }
            }
            doc.add(new Paragraph(parrafo));
            JOptionPane.showMessageDialog(null, "Se ha creado la consulta en "+direccion, "Listo", JOptionPane.INFORMATION_MESSAGE);
            doc.close();
            pd.close();
            pw.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    static int cantidaDeRegistros() {
        int numeroRegistro = -1, caracter = 0;
        try {
            InputStream is = new FileInputStream("OJDemandas.txt");
            while (caracter != -1) {
                caracter = is.read();
                if ("#".equals(String.valueOf((char) caracter))) {
                    numeroRegistro++;
                }
            }
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return numeroRegistro;
    }
}
