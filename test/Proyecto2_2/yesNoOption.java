package Proyecto2_2;

import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */
public class yesNoOption {
    public static void main(String[] args) {
        int veredicto = 0;
        veredicto = JOptionPane.showConfirmDialog(null, "¿Ganó la demanda?", "Ingreso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Numero ingresado: "+veredicto, "Salida", JOptionPane.INFORMATION_MESSAGE);
        /*
                0   Si
                1   No
                -1  Error
        */
    }
}
