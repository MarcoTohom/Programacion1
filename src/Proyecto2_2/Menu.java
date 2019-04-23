package Proyecto2_2;

import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Menu {

    public static void main(String[] args) {
        try {
            String opcion = "opcion";
            do {
                opcion = JOptionPane.showInputDialog("\nEliga una opcion:"
                        + "\n1 Agregar demanda."
                        + "\n2 Agregar juez a una demanda."
                        + "\n3 Agregar veredicto una demanda"
                        + "\n4 Consultar demanda"
                        + "\n5 Eliminar demanda"
                        + "\n0 Salir\n"
                );
                switch (opcion) {
                    case "0":
                        //se agrega el caso 0 para que no vaya a default ni marque error
                        break;
                    case "1":
                        Agregar.solicitarAgregarDemanda();
                        break;
                    case "2":
                        Agregar.solicitarAgregarJuez();
                        break;
                    case "3":
                        Agregar.solicitarAgregarVeredicto();
                        break;
                    case "4":
                        Consultar.solicitarConsultar();
                        break;
                    case "5":
                        JOptionPane.showMessageDialog(null, "Eliminar demanda");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Introduzca un valor del menu.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } while (!("0".equalsIgnoreCase(opcion)));
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
