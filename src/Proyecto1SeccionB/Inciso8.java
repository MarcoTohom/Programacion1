/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1SeccionB;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Inciso8 {

    static char letra = '0';
    static int fallos = 0;

    public static void main(String[] args) {
        String[] sopaDePalabras = new String[]{"pelota", "telefono", "escalera", "bandera", "carpeta", "computadora", "enciclopedia", "automovil", "barril", "caballero"};
        String eleccion, temp="s";
        eleccion = sopaDePalabras[(int) (Math.random() * 10)];
        char[] palabra;
        palabra = eleccion.toCharArray();
        Scanner sc = new Scanner(System.in);
        //System.out.println(eleccion);
        //System.out.println(palabra.length);
        //System.out.println(palabra);
        do {
            System.out.println("Ingrese una letra:");
            temp=sc.next();
            letra=temp.charAt(0);
            System.out.println("letra ingresada:"+letra);
            for (int i = 0; i < palabra.length; i++) {
                if (letra==palabra[i]) {
                    System.out.print(letra);
                }else{
                    System.out.print("_");
                }
            }
            //letra=(char) sc.next();
            fallos = 6;
        } while (fallos < 6);

    }
}
