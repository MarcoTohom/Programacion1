package Proyecto1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Inciso4 {

    static double parcial1 = 0, parcial2 = 0, tareas = 0, examenFinal = 0, notaFinal;
    static Scanner escaner = new Scanner(System.in);
    
    public static void main(String[] args) {
        String nombre = "Marco";
        try {
            System.out.print("Ingrese nombre:");
            nombre = escaner.nextLine();
            //Primer parcial
            parcial1=primerParcial();
            //Segundo parcial
            do {
                if (parcial2 < -1 || parcial2 > 101) {
                    System.out.print("El porcentaje debe estar entre 0 y 100\n");
                }
                System.out.print("Ingrese punteo de segundo parcial:");
                parcial2 = escaner.nextDouble();
            } while (parcial2 < -1 || parcial2 > 101);
            //Tareas
            do {
                if (tareas < -1 || tareas > 101) {
                    System.out.print("El porcentaje debe estar entre 0 y 100\n");
                }
                System.out.print("Ingrese punteo de tareas:");
                tareas = escaner.nextDouble();
            } while (tareas < -1 || tareas > 101);
            //Examen final
            do {
                if (examenFinal < -1 || examenFinal > 101) {
                    System.out.print("El porcentaje debe estar entre 0 y 100\n");
                }
                System.out.print("Ingrese punteo de exámen final:");
                examenFinal = escaner.nextDouble();
            } while (examenFinal > -1 && examenFinal < 101);
            //Porcentaje de cada valor
            parcial1 = parcial1 / 10;
            parcial2 = parcial2 / 5;
            tareas = tareas / 5;
            examenFinal = examenFinal / 2;
            notaFinal = (parcial1 + parcial2 + tareas + examenFinal);
            //Comprobación de ganado
            if (notaFinal >= 61) {
                System.out.print("\n" + nombre + " ganó con " + notaFinal + " puntos.");
            } else {
                System.out.print("\n" + nombre + " perdió con " + notaFinal + " puntos.");
            }
        } catch (InputMismatchException ime) {
            System.out.println("Se ingresó un valor inválido.");
        }
    }

    public static double primerParcial() {
        try {
            do {
                if (parcial1 < 0 || parcial1 > 100) {
                    System.out.print("El porcentaje debe estar entre 0 y 100\n");
                }
                System.out.print("Ingrese punteo de primer parcial:");
                parcial1 = escaner.nextDouble();
            } while (parcial1 < 0 || parcial1 > 100);
        } catch (InputMismatchException ime) {
            System.out.println("Se ingresó un valor inválido.");
        }
        return parcial1;
    }
}
