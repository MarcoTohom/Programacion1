package Proyecto1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Inciso4 {

    static double parcial1 = 0, parcial2 = 0, tareas = 0, examenFinal = 0, notaFinal;
    static Scanner escaner = new Scanner(System.in);
    static String nombre = "Marco";

    public static void main(String[] args) {
        try {
            System.out.print("Ingrese nombre:");
            nombre = escaner.nextLine();
            //Primer parcial
            parcial1 = primerParcial();
            //Segundo parcial
            parcial2 = segundoParcial();
            //Tareas
            tareas = metodoTareas();
            //Examen final
            examenFinal = metodoExamenFinal();
            comprobacion();
        } catch (InputMismatchException ime) {
            System.out.println("Se ingresó un valor inválido.");
        }
    }

    public static double primerParcial() {
        do {
            if (parcial1 < 0 || parcial1 > 100) {
                System.out.print("El porcentaje debe estar entre 0 y 100\n");
            }
            System.out.print("Ingrese punteo de primer parcial:");
            parcial1 = escaner.nextDouble();
        } while (parcial1 < 0 || parcial1 > 100);
        return parcial1;
    }

    public static double segundoParcial() {
        do {
            if (parcial2 < 0 || parcial2 > 100) {
                System.out.print("El porcentaje debe estar entre 0 y 100\n");
            }
            System.out.print("Ingrese punteo de segundo parcial:");
            parcial2 = escaner.nextDouble();
        } while (parcial2 < 0 || parcial2 > 100);
        return parcial2;
    }

    public static double metodoTareas() {
        do {
            if (tareas < 0 || tareas > 100) {
                System.out.print("El porcentaje debe estar entre 0 y 100\n");
            }
            System.out.print("Ingrese punteo de tareas:");
            tareas = escaner.nextDouble();
        } while (tareas < 0 || tareas > 100);
        return tareas;
    }

    public static double metodoExamenFinal() {
        do {
            if (examenFinal < 0 || examenFinal > 100) {
                System.out.print("El porcentaje debe estar entre 0 y 100\n");
            }
            System.out.print("Ingrese punteo del examen final:");
            examenFinal = escaner.nextDouble();
        } while (examenFinal < 0 || examenFinal > 100);
        return examenFinal;
    }

    public static void comprobacion() {
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
    }
}
