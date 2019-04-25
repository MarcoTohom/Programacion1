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
                    //Se agrega el caso para que no marque error
                    case "salir":
                        break;
                    //Casos de Buscar
                    case "buscarDemanda":
                        testBuscarDemanda();
                        break;
                    //Casos de Consultar
                    case "consultarDemanda":
                        testConsultarDemanda();
                        break;
                    case "consultarJuez":
                        testConsultarJuez();
                        break;
                    case "cantidadDeRegistros":
                        testCantidadDeRegistros();
                        break;
                    //Casos de Eliminar
                    case "consultarDemandaEliminada":
                        testConsultarDemandaEliminada();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, opcion +" es una opcion incorrecta", "Error.", JOptionPane.WARNING_MESSAGE);
                        break;
                }
            } while (!("salir".equals(opcion)));
        } catch (HeadlessException he) {
            JOptionPane.showMessageDialog(null, "Error");
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    //Metodos de test para la clase Buscar
    static void testBuscarDemanda() {
        String nombreDemandante = JOptionPane.showInputDialog("Nombre demandante: ");
        String nombreDemandado = JOptionPane.showInputDialog("Nombre demandante: ");
        int numeroRegistro = Buscar.buscarDemanda(nombreDemandante, nombreDemandado);
        JOptionPane.showMessageDialog(null, "Numero de registro: "+numeroRegistro, "Salida", JOptionPane.INFORMATION_MESSAGE);
    }
    //Metodos de test para la clase Consultar
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
    
    static void testCantidadDeRegistros() {
        int numeroRegistro = Consultar.cantidaDeRegistros();
        JOptionPane.showMessageDialog(null, numeroRegistro);
    }
    
    //Metodos de test para la clase Eliminar
    static void testConsultarDemandaEliminada() {
        int numeroRegistro = Integer.valueOf(JOptionPane.showInputDialog(null, "Numero de registro", "Ingreso", JOptionPane.QUESTION_MESSAGE));
        boolean eliminado = Eliminar.consultarDemandaEliminada(numeroRegistro);
        JOptionPane.showMessageDialog(null, "Estado eliminado: "+eliminado, "Salida", JOptionPane.INFORMATION_MESSAGE);
    }
}
