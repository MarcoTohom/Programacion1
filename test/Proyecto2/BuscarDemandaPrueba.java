package Proyecto2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class BuscarDemandaPrueba {

    public static int buscarDemanda() {
        Scanner sc = new Scanner(System.in);
        String terminoDeBusqueda = "";
        int retorno = -1;
        do {
            System.out.println("");
            System.out.println("Ingrese nombre completo de demandante o demandado:");
            terminoDeBusqueda = sc.nextLine();
            retorno=busquedaDemanda(terminoDeBusqueda);
        } while ("".equals(terminoDeBusqueda));
        return retorno;
    }

    public static int busquedaDemanda(String pTerminoDeBusqueda) {
        String registro = "";
        int linea = -1;
        boolean encontrado=false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("demandas.txt"));
            while ((registro = br.readLine()) != null) {
                linea++;
                if (registro.contains(pTerminoDeBusqueda)) {
                    encontrado = true;
                    break;
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("No se ha encontrado la base de datos.");
        } catch (IOException ioex) {
            System.out.println("Ha ocurrido un fallo en la escritura/lectura.");
        }
        if (encontrado == false){
            linea = -1;
        }
        return linea;
    }

    public static int buscarJuez() {
        int retorno = 0;

        return retorno;
    }
}
