package Proyecto2_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Agregar {

    static Scanner sc = new Scanner(System.in);

    static void solicitarAgregarDemanda() {
        String nombreDemandante = "", nombreDemandado = "", direccionDemandado = "", montoPension = "",
                registro = "";
        System.out.print("\nIngrese nombre de demandante: ");
        nombreDemandante = sc.nextLine();
        System.out.print("\nIngrese nombre de demandado: ");
        nombreDemandado = sc.nextLine();
        System.out.print("\nIngrse direccion del demandado: ");
        direccionDemandado = sc.nextLine();
        System.out.print("\nIngrese el monto de la pension: ");
        montoPension = sc.nextLine();
        registro = registro.concat(nombreDemandante).concat("…").concat(nombreDemandado).concat("…").concat(direccionDemandado).concat("…").concat(montoPension).concat("…").concat("Þ");
        registro = registro.toLowerCase();
        agregarDemanda(registro);
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
    }
    
    static void agregarJuez() {
    }
}
