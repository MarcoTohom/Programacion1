package Proyecto1;

import java.util.Scanner;

public class Inciso2 {

    public static void main(String[] args) {
        int aleatorio = -1, respuesta = -1; //Se crean las variables del número aleatorio y respuesta con valores iguales y fuera del rango a evaluar
        String aux = "";
        Scanner escaner = new Scanner(System.in); //Se crea un objeto del tipo Scanner para guardar el valor del número que el usuario deberá guardar
        aleatorio = (int) (Math.random() * 100);     //Con la función Math.random() se obtiene un valor aleatorio y se guarda en su respectiva variable
        do {
            System.out.println("Adivine el número desde 0 a 100:");
            aux = escaner.next();
            aux = aux.replaceAll("[^0-9]", "");
            if (!("".equalsIgnoreCase(aux))) {
                respuesta = Integer.valueOf(aux);
                if (respuesta == aleatorio) {
                    System.out.println("FELICIDADES! GANÓ!");
                } else {
                    if (aleatorio < respuesta) {
                        System.out.println("El número es menor.");
                    } else {
                        System.out.println("El número es mayor.");
                    }
                }
            } else {
                System.out.println("Solo debe ingresar números.");
            }
        } while (respuesta != aleatorio);
    }
}
