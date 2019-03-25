package Proyecto1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Inciso4 {
    public static void main(String[] args) {
        String nombre="Marco";
        double parcial1=0, parcial2=0, tareas=0, examenFinal=0, notaFinal;
        Scanner escaner = new Scanner(System.in);
        try{
            System.out.print("Ingrese nombre:");
            nombre=escaner.nextLine();
            System.out.print("Ingrese punteo de primer parcial:");
            parcial1=escaner.nextDouble();
            System.out.print("Ingrese punteo de segundo parcial:");
            parcial2=escaner.nextDouble();
            System.out.print("Ingrese punteo de tareas:");
            tareas=escaner.nextDouble();
            System.out.print("Ingrese punteo de exámen final:");
            examenFinal=escaner.nextDouble();
            
            parcial1=parcial1/10;
            parcial2=parcial2/5;
            tareas=tareas/5;
            examenFinal=examenFinal/2;
            notaFinal=(parcial1+parcial2+tareas+examenFinal);
            if (notaFinal>=61) {
                System.out.print("\n"+nombre+" ganó con "+notaFinal+" puntos.");
            }else{
                System.out.print("\n"+nombre+" perdió con "+notaFinal+" puntos.");
            }
        }catch(InputMismatchException ime){
            System.out.println("Se ingresó un valor inválido.");
        }
    }
}
