package Proyecto2_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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
        List<String> listaRegistro;
        String registro = "";
        int numeroRegistro = 0, caracter = 0;
        
        listaRegistro = new ArrayList<>();
        pTerminoDeBusqueda = pTerminoDeBusqueda.toLowerCase();
        
        try {
            InputStream is = new FileInputStream("OJDemandas.txt");
            while (caracter != -1) {
                caracter = is.read();
                if ( "#".equals((char)caracter)) {
                    if (registro.contains(pTerminoDeBusqueda)) {
                        listaRegistro.add(registro);
                        System.out.println(registro);
                    }
                } else {
                    registro = registro.concat(String.valueOf((char)caracter));
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("Ha ocurrido un error. No se ha podido localizar el archivo.");
        } catch (IOException ex) {
            System.err.println("Ha ocurrido un error de lectura/escritura.");
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
