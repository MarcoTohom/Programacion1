package Proyecto2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class BuscarDemanda {

    static Scanner sc = new Scanner(System.in);

    public static int solicitarBuscarDemanda() {
        String terminoDeBusqueda = "";
        int linea = 0;

        System.out.println("");
        System.out.println("Ingrese nombre completo de demandante o demandado:");
        
        terminoDeBusqueda = sc.nextLine();
        terminoDeBusqueda = terminoDeBusqueda.toUpperCase();

        linea = buscarDemanda(terminoDeBusqueda);

        return linea;
    }

    public static int buscarDemanda(String pTerminoDeBusqueda) {
        String registro = "";
        int linea = -1;
        boolean encontrado = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("demandas.txt"));
            while ((registro = br.readLine()) != null) {
                System.out.println(linea);
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
        if (!encontrado) {
            linea = -1;
        }
        return linea;
    }

    public static int buscarJuez(int pLinea) {
        String registro = "";
        boolean encontrado = false;
        int linea = 0;

        try {
            
            BufferedReader br = new BufferedReader(new FileReader("jueces.txt"));
            
            while ((registro = br.readLine()) != null) {
                
                String campo[] = registro.split("[^0-9]");
                int campoInt[] = new int [campo.length];
                
                for (int i = 0; i < campo.length; i++) {
                    campoInt[i] = Integer.valueOf(campo[i]);
                }
                
                if (campoInt[0] == pLinea) {
                    encontrado = true;
                    break;
                }
                linea++;
                
            }
            if (encontrado == false) {
                pLinea = -1;
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("No se ha encontrado la base de datos.");
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un fallo en la escritura/lectura.");
        }

        return pLinea;
    }
}
