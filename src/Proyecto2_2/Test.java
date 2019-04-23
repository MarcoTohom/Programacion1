/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto2_2;

import java.awt.HeadlessException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Marco
 */
public class Test {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            String opcion = JOptionPane.showInputDialog("Ingrese opcion:");
            switch (opcion) {
                case "consultarDemanda":
                    testConsultarDemanda();
                    break;
                case "consultarJuez":
                    testConsultarJuez();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } catch (HeadlessException he) {
            System.out.println("Error");
        } catch (NumberFormatException nfe) {
            System.out.println("Error nfe");
        }
    }
    
    static void testConsultarJuez() {
        try {
            System.out.println("Ingrese numero de registro:");
            int numeroRegistro = sc.nextInt();
            String registroJuez = Consultar.consultarJuez(numeroRegistro);
            System.out.println("Registro de juez: "+registroJuez);
        } catch (NumberFormatException nfe) {
            
        }
    }
    static void testConsultarDemanda() {
        System.out.println("Nombre demandante:");
        String nombreDemandante = sc.nextLine();
        System.out.println("Nombre demandado:");
        String nombreDemandado = sc.nextLine();
        String registro = Consultar.consultarDemanda(nombreDemandante, nombreDemandado);
        System.out.println("Registro "+registro);
    }
}
