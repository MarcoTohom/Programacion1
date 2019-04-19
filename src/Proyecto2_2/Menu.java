package Proyecto2_2;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Menu {

    public static void main(String[] args) {
        String opcion = "opcion";
        try {
            do {
                opcion = JOptionPane.showInputDialog("\nEliga una opcion:"
                        + "\n1 Agregar demanda."
                        + "\n2 Agregar juez a una demanda."
                        + "\n3 Agregar veredicto una demanda"
                        + "\n4 Consultar demanda"
                        + "\n0 Salir\n"
                );
                switch (opcion) {
                    case "1":
                        Agregar.solicitarAgregarDemanda();
                        break;
                    case "2":
                        Agregar.solicitarAgregarJuez();
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
                    default:
                        JOptionPane.showMessageDialog(null, "\nIntroduzca un valor del menu.\n");
                        break;
                }
            } while (!("0".equalsIgnoreCase(opcion)));
        } catch (Exception ioe) {
            JOptionPane.showMessageDialog(null, "\nHa ocurrido un erros inesperado\n");
        }
    }
}
