package Proyecto2_2;

import java.util.Scanner;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion = "opcion";
        do {
            System.out.print("\nEliga una opcion"
                    + "\n1 Agregar demanda"
                    + "\n2 Agregar juez una demanda"
                    + "\n3 Agregar veredicto una demanda"
                    + "\n4 Consultar demanda"
                    + "\n0 Salir\n");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    Agregar.solicitarAgregarDemanda();
                    break;
                case "2":
                    //AgregarJuez.solicitarAgregarJuez();
                    break;
                case "3":
                    System.out.print("\nAgregar veredicto una demanda");
                    break;
                case "4":
                    System.out.print("\nConsultar demanda");
                    break;
                case "0":
                    System.out.print("\nSaliendo...\n");
                    break;
                case "solicitarBuscarDemanda":
                    Buscar.solicitarBuscarDemanda();
                    break;
                default:
                    System.err.print("\nIntroduzca un valor del menu.\n");
                    break;
            }
        } while (!("0".equalsIgnoreCase(opcion)));
    }
}
