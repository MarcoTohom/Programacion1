package Proyecto3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author Marco Antonio Lares Tohom
 */

public class Agregar extends javax.swing.JFrame {
    
    static void agregarEvento(String pFechaEvento, String pNombreArtista, int pCantidadAsistentes) {
        try {
            RandomAccessFile raf = new RandomAccessFile("eventos.bin", "rw");
            raf.seek(raf.length());
            raf.writeUTF(pFechaEvento);
            raf.writeUTF(pNombreArtista);
            raf.writeInt(pCantidadAsistentes);
            raf.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "Error", "Archivo no encontrado.", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error", "Ha ocurrido un fallo en la escritura o lectura de la Base de Datos.", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public Agregar() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxDia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldArtista = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonAgregarEvento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSpinnerCantidadAsistentes = new javax.swing.JSpinner();
        jComboBoxYear = new javax.swing.JComboBox<>();
        jButtonRegresar = new javax.swing.JButton();
        jComboBoxMes = new javax.swing.JComboBox<>();
        jComboBoxHora = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 200));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jComboBoxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBoxDia.setEnabled(false);
        jComboBoxDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDiaActionPerformed(evt);
            }
        });

        jLabel2.setText("Mes");

        jLabel3.setText("Dia");

        jLabel4.setText("Hora");

        jTextFieldArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldArtistaActionPerformed(evt);
            }
        });
        jTextFieldArtista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldArtistaKeyTyped(evt);
            }
        });

        jLabel5.setText("Artista:");

        jLabel6.setText("Numero de asistentes:");

        jButtonAgregarEvento.setText("Agregar Evento");
        jButtonAgregarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarEventoActionPerformed(evt);
            }
        });

        jLabel1.setText("Año:");

        jSpinnerCantidadAsistentes.setModel(new javax.swing.SpinnerNumberModel(100, 100, 5000, 1));

        jComboBoxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxYearActionPerformed(evt);
            }
        });

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        jComboBoxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBoxMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMesActionPerformed(evt);
            }
        });

        jComboBoxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jComboBoxHora.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonRegresar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinnerCantidadAsistentes, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAgregarEvento)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerCantidadAsistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregarEvento)
                    .addComponent(jButtonRegresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDiaActionPerformed
        // TODO add your handling code here:
        jComboBoxHora.setEnabled(true);
    }//GEN-LAST:event_jComboBoxDiaActionPerformed

    private void jButtonAgregarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarEventoActionPerformed
        //Se crea una variable de tipo Date con la fecha actual y una que contendrá la fecha del evento
        Date fechaActual = new Date(), fechaEvento;
        String artista;
        int month = 1, cantidadAsistentes = 0;
        fechaActual.setYear(fechaActual.getYear()+1900);
        // <editor-fold defaultstate="collapsed" desc="Switch month">
        switch ((String)jComboBoxMes.getSelectedItem()) {
            case "Enero":
            month = 1; break;
            case "Febrero":
            month = 2; break;
            case "Marzo":
            month = 3; break;
            case "Abril":
            month = 4; break;
            case "Mayo":
            month = 5; break;
            case "Junio":
            month = 6; break;
            case "Julio":
            month = 7; break;
            case "Agosto":
            month = 8; break;
            case "Septiembre":
            month = 9; break;
            case "Octubre":
            month = 10; break;
            case "Noviembre":
            month = 11; break;
            case "Diciembre":
            month = 12; break;
            default:
            month = 1; break;
        }// </editor-fold>
        //Se crea la fecha del evento con los parámetros que se obtienen de los ComboBox respectivos y 0 para los minutos
        fechaEvento = new Date(Integer.parseInt((String)jComboBoxYear.getSelectedItem()),
            month,
            Integer.parseInt((String)jComboBoxDia.getSelectedItem()),
            Integer.parseInt((String)jComboBoxHora.getSelectedItem()),
            0
        );
        //Se extrae el nombre del artista de la caja de texto
        artista = jTextFieldArtista.getText();
        //Se extrae la cantidad de asistentes del spinner
        cantidadAsistentes = Integer.parseInt(String.valueOf(jSpinnerCantidadAsistentes.getValue()));
        if (fechaEvento.before(fechaActual)) {
            JOptionPane.showMessageDialog(rootPane, "La fecha no puede ser una fecha anterior al momento de hoy", "Error", 0);
        } else if (!(jComboBoxDia.isEnabled())
                && !(jComboBoxHora.isEnabled())
                && (jTextFieldArtista.getText().equals(""))
                && (jSpinnerCantidadAsistentes.getValue().equals("0"))) {
            JOptionPane.showMessageDialog(rootPane, "Debe llenar todos los campos");
        } else {
            agregarEvento(fechaEvento.toString(), artista, cantidadAsistentes);
        }
    }//GEN-LAST:event_jButtonAgregarEventoActionPerformed

    private void jComboBoxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxYearActionPerformed
        // TODO add your handling code here:
        jComboBoxMes.setEnabled(true);
    }//GEN-LAST:event_jComboBoxYearActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // TODO add your handling code here:
        Menu ventanaMenu = new Menu();
        ventanaMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jComboBoxMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMesActionPerformed
        // TODO add your handling code here:
        jComboBoxDia.setEnabled(true);
        switch (jComboBoxMes.getSelectedIndex()) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                jComboBoxDia.removeAllItems();
                for (int i = 1; i < 32; i++) {
                    jComboBoxDia.addItem(String.valueOf(i));
                }
                break;
            case 1:
                jComboBoxDia.removeAllItems();
                if ((jComboBoxYear.getSelectedIndex() + 1) % 4 == 0) {
                    for (int i = 1; i < 30; i++) {
                        jComboBoxDia.addItem(String.valueOf(i));
                    }
                } else {
                    for (int i = 1; i < 29; i++) {
                        jComboBoxDia.addItem(String.valueOf(i));
                    }
                }
                break;
            default:
                jComboBoxDia.removeAllItems();
                for (int i = 1; i < 31; i++) {
                    jComboBoxDia.addItem(String.valueOf(i));
                }
                break;
        }
    }//GEN-LAST:event_jComboBoxMesActionPerformed

    private void jTextFieldArtistaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldArtistaKeyTyped
        // TODO add your handling code here:
        if (jTextFieldArtista.getText().length()>= 10) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "El nombre excede el limite de letras establecido", "Error", 0);
        }
    }//GEN-LAST:event_jTextFieldArtistaKeyTyped

    private void jTextFieldArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldArtistaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Date fechaActual = new Date();
        int yearActual = fechaActual.getYear() + 1900;
        for (int i = yearActual; i < (yearActual + 10); i++) {
            jComboBoxYear.addItem(String.valueOf(i));
        }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar().setVisible(true);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarEvento;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JComboBox<String> jComboBoxDia;
    private javax.swing.JComboBox<String> jComboBoxHora;
    private javax.swing.JComboBox<String> jComboBoxMes;
    private javax.swing.JComboBox<String> jComboBoxYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner jSpinnerCantidadAsistentes;
    private javax.swing.JTextField jTextFieldArtista;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
