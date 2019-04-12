package Proyecto2;

import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion = "opcion";
        do {
            System.out.println("");
            System.out.println("Eliga una opcion");
            System.out.println("1 Agregar demanda");
            System.out.println("2 Agregar juez una demanda");
            System.out.println("3 Agregar veredicto una demanda");
            System.out.println("4 Consultar demanda");
            System.out.println("0 Salir");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    AgregarDemanda.solicitarAgregarDemanda();
                    break;
                case "2":
                    AgregarJuez.solicitarAgregarJuez();
                    break;
                case "3":
                    System.out.println("Agregar veredicto una demanda");
                    break;
                case "4":
                    System.out.println("Consultar demanda");
                    break;
                case "0":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("");
                    System.out.println("Ha elegido una opción inválida.");
                    break;
            }
        } while (!("0".equalsIgnoreCase(opcion)));
    }
}
