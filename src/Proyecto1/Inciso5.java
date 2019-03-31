/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class Inciso5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int[] fecha = {0,0,0};
        do {
            System.out.println("Ingrese una fecha mayor a 01 de enero de 1978");
            System.out.print("Ingrese año:");
            fecha[0]=sc.nextInt();
            
        } while (verificarFecha(fecha[0], fecha[1], fecha[2])==0);
        
    }
    public static void pedirFechas(int pDay, int pMonth, int pYear){
        
    }
    public static int verificarFecha(int pDay, int pMonth, int pYear){
        int fechaValidaFechaInvalida=9;
        return fechaValidaFechaInvalida;
    }
    public static int calculoDeDias(int pDay, int pMonth, int pYear){
        int diasTranscurridos=0;
        return diasTranscurridos;
    }
    public static int bisiesto(int pYear){
        return 1;
    }
}
