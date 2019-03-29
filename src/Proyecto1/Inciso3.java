package Proyecto1;

import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class Inciso3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = "", vectorEntrada[];
        System.out.print("Ingrese operacion: ");
        entrada = sc.nextLine();
        vectorEntrada = entrada.split("[ ]");

        /*for (int i = 0; i < vectorEntrada.length; i++) {
            System.out.println("Elemento "+i+": "+vectorEntrada[i]);
        }
         */
        operar(vectorEntrada);

    }

    public static void operar(String[] operacion) {
        Integer numeros, prioridades;
        String[] operaciones;
        String temp;
        numeros = new Integer(operacion.length);
        prioridades = new Integer(operacion.length);
        operaciones = new String[operacion.length];
        for (int i = 0; i < operacion.length; i++) {
            temp = operacion[i];
            temp=temp.replaceAll("[^0-9]", "");
            if ("".equals(temp)) {
                operaciones[i]=operacion[i];
                //prioridades[i]=priorizar(operacion[i]);
            }
        }
    }
    public static Integer priorizar(String pOperaciones){
        Integer prioridad=0;
        switch(pOperaciones){
            case "(": prioridad=1; break;
            case ")": prioridad=1; break;
            case "elevado": prioridad=2; break;
            case "por": prioridad=3; break;
            case "dividido": prioridad=4; break;
            case "mas": prioridad=5; break;
            case "menos": prioridad=6; break;
            default: prioridad=0;
        }
        return prioridad;
    }
}
