/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto3;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marco
 */
public class Agenda extends javax.swing.JFrame {
    static DefaultTableModel modeloTabla;
    /**
     * Creates new form Agenda
     */
    void consult() {
        jTableSchedule.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableSchedule.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTableSchedule.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTableSchedule.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTableSchedule.getColumnModel().getColumn(4).setPreferredWidth(425);
        jTableSchedule.getColumnModel().getColumn(5).setPreferredWidth(50);
        String registry[] = new String[6];
        try {
            RandomAccessFile raf = new RandomAccessFile("eventos.bin", "r");
            int order[] = new int [Integer.parseInt(String.valueOf(raf.length() / 52))];
            
            for (int i = 0; i < raf.length() / 52; i++) {
                registry[3] = String.valueOf(raf.readInt());
                registry[2] = String.valueOf(raf.readInt());
                registry[1] = String.valueOf(raf.readInt());
                registry[0] = String.valueOf(raf.readInt());
                registry[4] = raf.readUTF().replaceAll("[|]", " ");
                registry[5] = String.valueOf(raf.readInt());
                modeloTabla.addRow(registry);
            }
            raf.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la base de datos.", "Error", 0);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la base de datos.", "Error", 0);
        }
    }
    public Agenda() {
        initComponents();
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Hora");
        modeloTabla.addColumn("Dia");
        modeloTabla.addColumn("Mes");
        modeloTabla.addColumn("Año");
        modeloTabla.addColumn("Artista");
        modeloTabla.addColumn("Cantidad asistentes");
        this.jTableSchedule.setModel(modeloTabla);
        consult();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSchedule = new javax.swing.JTable();
        jButtonToReturn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGENDA");
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setText("LISTA DE EVENTOS");

        jTableSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hora", "Dia", "Mes", "Año", "Artista", "Cantidad asistentes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableSchedule.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTableSchedule);

        jButtonToReturn.setText("Regresar");
        jButtonToReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonToReturnActionPerformed(evt);
            }
        });

        jButton1.setText("Ordenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonToReturn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonToReturn)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonToReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonToReturnActionPerformed
        // TODO add your handling code here:
        Menu ventanaMenu = new Menu();
        ventanaMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonToReturnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            RandomAccessFile rafEvents = new RandomAccessFile("eventos.bin", "rw");
            int yearA, yearB = 0, monthA = 0, monthB = 0, dayA = 0, dayB = 0, hourA = 0, hourB = 0, cantidadA = 0, cantidadB = 0;
            String artistaA = "", artistaB = "";
            for (long i = 1; i < rafEvents.length() / 52; i++) {
                rafEvents.seek(i*52);
                yearA = rafEvents.readInt();
                monthA = rafEvents.readInt();
                dayA = rafEvents.readInt();
                hourA = rafEvents.readInt();
                artistaA = rafEvents.readUTF();
                cantidadA = rafEvents.readInt();
                for (long j = 0; j < i; j++) {
                    rafEvents.seek(j*52);
                    yearB = rafEvents.readInt();
                    monthB = rafEvents.readInt();
                    dayB = rafEvents.readInt();
                    hourB = rafEvents.readInt();
                    artistaB = rafEvents.readUTF();
                    cantidadB = rafEvents.readInt();
                    if (cantidadB > cantidadA) { //yearB > yearA
                        rafEvents.seek(i*52);
                        rafEvents.writeInt(yearB);
                        rafEvents.writeInt(monthB);
                        rafEvents.writeInt(dayB);
                        rafEvents.writeInt(hourB);
                        rafEvents.writeUTF(artistaB);
                        rafEvents.writeInt(cantidadB);
                        
                        rafEvents.seek(j*52);
                        rafEvents.writeInt(yearA);
                        rafEvents.writeInt(monthA);
                        rafEvents.writeInt(dayA);
                        rafEvents.writeInt(hourA);
                        rafEvents.writeUTF(artistaA);
                        rafEvents.writeInt(cantidadA);
                    } 
                    /*else if(yearB == yearA && monthB > monthA) {
                        rafEvents.seek(i*52);
                        rafEvents.writeInt(yearB);
                        rafEvents.writeInt(monthB);
                        rafEvents.writeInt(dayB);
                        rafEvents.writeInt(hourB);
                        rafEvents.writeUTF(artistaB);
                        rafEvents.writeInt(cantidadB);
                        
                        rafEvents.seek(j*52);
                        rafEvents.writeInt(yearA);
                        rafEvents.writeInt(monthA);
                        rafEvents.writeInt(dayA);
                        rafEvents.writeInt(hourA);
                        rafEvents.writeUTF(artistaA);
                        rafEvents.writeInt(cantidadA);
                    } else if(yearB == yearA && monthB == monthB && dayB > dayA) {
                        rafEvents.seek(i*52);
                        rafEvents.writeInt(yearB);
                        rafEvents.writeInt(monthB);
                        rafEvents.writeInt(dayB);
                        rafEvents.writeInt(hourB);
                        rafEvents.writeUTF(artistaB);
                        rafEvents.writeInt(cantidadB);
                        
                        rafEvents.seek(j*52);
                        rafEvents.writeInt(yearA);
                        rafEvents.writeInt(monthA);
                        rafEvents.writeInt(dayA);
                        rafEvents.writeInt(hourA);
                        rafEvents.writeUTF(artistaA);
                        rafEvents.writeInt(cantidadA);
                    }
                    */
                }
            }
            this.jTableSchedule.removeRowSelectionInterval(0, Integer.parseInt(String.valueOf(rafEvents.length()/52))-1);
            rafEvents.close();
            consult();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "base de datos no encontrado", "Error", 1);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Fallo al escribir/leer en la base de datos", "Error", 1);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonToReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSchedule;
    // End of variables declaration//GEN-END:variables
}
