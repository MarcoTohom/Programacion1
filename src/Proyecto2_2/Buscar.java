package Proyecto2_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Buscar {

    static Scanner sc = new Scanner(System.in);

    static int solicitarBuscarDemanda() {
        String terminoDeBusqueda = "";
        int numeroRegistro = 0;

        System.out.print("\nIngrese nombre completo de demandante o del demandado: ");
        terminoDeBusqueda = sc.nextLine();
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
                String stringCaracter = String.valueOf((char)caracter);
                if ( "#".equals(stringCaracter)) {
                    registro = registro.toLowerCase();
                    if (registro.contains(pTerminoDeBusqueda)) {
                        encontrado = true;
                        break;
                        //System.out.println(registro);
                        /*String[] vectorRegistro = registro.split("[@]");
                        for (int i = 0; i < vectorRegistro.length; i++) {
                            System.out.println(vectorRegistro[i]);
                        }*/
                    }
                    registro = "";
                    numeroRegistro++;
                } else {
                    registro = registro.concat(String.valueOf((char)caracter));
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("Ha ocurrido un error. No se ha podido localizar el archivo.");
        } catch (IOException ex) {
            System.err.println("Ha ocurrido un error de lectura/escritura.");
        }
        if (!encontrado) {
            numeroRegistro = -1;
        }
        return numeroRegistro;
    }

    static int solicitarBuscarJuez() {
        int numeroRegistro = 0;

        return numeroRegistro;
    }

    static int buscarJuez(int pNumeroRegistro) {
        int numeroRegistro = 0;

        return numeroRegistro;
    }

    static int buscarVeredicto(int pNumeroRegistro) {
        int numeroRegistro = 0;

        return numeroRegistro;
    }
}
