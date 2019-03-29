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
        vectorEntrada = entrada.split("[ ]");// genera vector usando de separación eespacio
        prioridades = new int[vectorEntrada.length];// crea vector de prioridades para ordenar las operaciones con el mismo tamaño de la entrada
        numeros = new Integer[vectorEntrada.length];// crea vector de números de tipo Integer para poder manejar valores vacios
        operar(vectorEntrada);// se manda a ejecutar el método operar
    }

    public static void operar(String[] pVectorEntrada) {//el método operar se encarga principalmente de ordenar los nuevos vectores y posteriormente trabajarlos
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
                    prioridades[i] = 2;
                    break;
                case "elevado":
                    prioridades[i] = 3;
                    break;
                case "por":
                    prioridades[i] = 4;
                    break;
                case "dividido":
                    prioridades[i] = 5;
                    break;
                case "mas":
                    prioridades[i] = 6;
                    break;
                case "menos":
                    prioridades[i] = 7;
                    break;
                default:
                    prioridades[i] = 0;
            }
        }
    }
    
    public static void numerar(String[] operacion){
        for (int i = 0; i < 10; i++) {
            
        }
    }
}
