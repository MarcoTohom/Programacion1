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
 * @author Marco Antonio Lares Tohom
 */
public class Test {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            String opcion;
            do {
                opcion = JOptionPane.showInputDialog("Ingrese opcion:");
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
            } while (!("salir".equals(opcion)));
        } catch (HeadlessException he) {
            System.out.println("Error");
        } catch (NumberFormatException nfe) {
            System.out.println("Error nfe");
        }
    }

    static void testConsultarJuez() {
        try {
            int numeroRegistro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de registro:"));
            String registroJuez = Consultar.consultarJuez(numeroRegistro);
            JOptionPane.showMessageDialog(null, "Registro de juez: " + registroJuez);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    static void testConsultarDemanda() {
        String nombreDemandante = JOptionPane.showInputDialog("Nombre demandante: ");
        String nombreDemandado = JOptionPane.showInputDialog("Nombre demandante: ");
        String registro = Consultar.consultarDemanda(nombreDemandante, nombreDemandado);
        JOptionPane.showMessageDialog(null, "Registro: " + registro);
    }
}
