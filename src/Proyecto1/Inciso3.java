package Proyecto1;

import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class Inciso3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String entrada="", vectorEntrada[];
        System.out.print("Ingrese operacion: ");
        entrada=sc.nextLine();
        vectorEntrada=entrada.split("[ ]");
        
        for (int i = 0; i < vectorEntrada.length; i++) {
            System.out.println("Elemento "+i+": "+vectorEntrada[i]);
        }
    }
}
