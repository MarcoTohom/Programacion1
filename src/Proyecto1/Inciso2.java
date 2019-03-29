package Proyecto1;

import java.util.Scanner;

public class Inciso2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aleatorio = (int) (Math.random() * 100), respuesta = -1;
        String aux = "";
        do {
            System.out.print("\nAdivine el número entre 0 y 100: ");
            aux = sc.next();
            aux = aux.replaceAll("[^0-9]", "");
            if (!("".equals(aux))) {
                respuesta = Integer.parseInt(aux);
                if (respuesta == aleatorio) {
                    System.out.print("¡Adivinó el número!\n");
                } else {
                    if (respuesta > aleatorio) {
                        if (respuesta > 100) {
                            System.out.print("El número debe estar en el rango de 0 y 100");
                        } else {
                            System.out.print("El número es menor.");
                        }
                    } else {
                        if (respuesta < 0 || respuesta == 0) {
                            System.out.print("El número debe estar en el rango de 0 y 100");
                        } else {
                            System.out.print("El número es mayor");
                        }
                    }
                }
            } else {
                System.out.print("Se debe ingresar solo números.");
            }

        } while (aleatorio != respuesta);

    }
}
