package Proyecto2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marco Antonio Lares Tohom
 */
public class BuscarJuez {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int linea = 0;
        
        System.out.print("Ingrese ID de demanda: ");
        linea = sc.nextInt();
        
        System.out.println("Linea: "+buscarJuez(linea));
    }
    public static int buscarJuez(int pLinea) {
        try {
            String registro = "";
            boolean encontrado = false;
            BufferedReader br = new BufferedReader(new FileReader("jueces.txt"));
            
            while ( (registro = br.readLine()) != null) {
                String campo[] = registro.split("[^0-9]");
                int campoInt[] = new int[campo.length];
                for (int i = 0; i < campo.length; i++) {
                    campoInt[i] = Integer.valueOf(campo[i]);
                }
                
                System.out.println("ID: "+campoInt[0]);
                if (campoInt[0] == pLinea) {
                    encontrado = true;
                    System.out.println("encontrado");
                    break;
                }
                
                if (encontrado==false) {
                    pLinea = -1;
                }
            }
            
        } catch (FileNotFoundException fnfe) {
            System.out.println("No se ha encontrado la base de datos.");
        } catch (IOException ex) {
            Logger.getLogger(BuscarJuez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pLinea;
    }
}
