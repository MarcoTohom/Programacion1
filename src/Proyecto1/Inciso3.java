package Proyecto1;

import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class Inciso3 {

    static int[] prioridades;
    static Integer[] numeros;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = "", vectorEntrada[];
        System.out.print("Ingrese operacion: ");
        entrada = sc.nextLine();
        vectorEntrada = entrada.split("[ ]");
        prioridades = new int[vectorEntrada.length];
        operar(vectorEntrada);
    }

    public static void operar(String[] pVectorEntrada) {
        priorizar(pVectorEntrada);
        numerar(pVectorEntrada);
    }

    public static void priorizar(String[] operacion) {
        for (int i = 0; i < operacion.length; i++) {
            switch (operacion[i]) {
                case "(":
                    prioridades[i] = 1;
                    break;
                case ")":
                    prioridades[i] = 1;
                    break;
                case "elevado":
                    prioridades[i] = 2;
                    break;
                case "por":
                    prioridades[i] = 3;
                    break;
                case "dividido":
                    prioridades[i] = 4;
                    break;
                case "mas":
                    prioridades[i] = 5;
                    break;
                case "menos":
                    prioridades[i] = 6;
                    break;
                default:
                    prioridades[i] = 5;
            }
        }
    }
    
    public static void numerar(String[] operacion){
        
    }
}
