/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class lectura {
    static void leer() {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("eventos.bin"));
            String fecha = dis.readUTF();
            JOptionPane.showMessageDialog(null, fecha);
            String hora = String.valueOf(dis.readInt());
            JOptionPane.showMessageDialog(null, hora);
            String artista = dis.readUTF();
            JOptionPane.showMessageDialog(null, artista);
            String totalAsistentes = String.valueOf(dis.readInt());
            JOptionPane.showMessageDialog(null, totalAsistentes);
            dis.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la base de datos.");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la conexión a la base de datos.");
        }
    }
}
