package Practicas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 * Carne 7690-15-24753
 */
public class Practica6 {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            InputStream is = new FileInputStream("info.txt");
            String palabra = "", palabraArchivo = "";
            int caracter = 0, contador = 0;
            System.out.println("Ingrese una palabra:");
            palabra = sc.next();
            while (caracter != -1) {
                caracter = is.read();
                //Se concatenan los caracteres
                palabraArchivo = palabraArchivo.concat(String.valueOf((char) caracter));
                //Se hacen ambos en mayúsculas para que no interfiera el encontrar la palabra en mayúscula o minúscula
                palabra = palabra.toUpperCase();
                palabraArchivo = palabraArchivo.toUpperCase();
                //Si encuentra la palabra en lo que va del archivo se reinicia el String que va guardando los datos...
                if (palabraArchivo.contains(palabra)) {
                    palabraArchivo = "";
                    contador++;//Y se aumenta en uno el contador
                }
            }
            System.out.println("Veces aparecidas: " + contador);
            is.close();
            sc.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Ha ocurrido un error. No se ha podido localizar el archivo.");
        } catch (IOException ex) {
            System.err.println("Ha ocurrido un error de lectura/escritura.");
        }
    }
}
