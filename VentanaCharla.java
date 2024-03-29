/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanaCharla.java
 *
 * Created on 23-mar-2010, 17:16:19
 */

package practica1ta;

import java.awt.event.*;
import java.io.*;

/**
 *
 * @author Jose
 */
public class VentanaCharla extends javax.swing.JFrame {
    private PrintWriter out;
    private String mensaje;
    private Lectura l;
    private String usuario;

    public VentanaCharla(String usuario,BufferedReader in,PrintWriter out){
        initComponents();
        this.usuario=usuario;
        this.out=out;
        botonEnvio.addKeyListener(new PresionarTecla());
        this.rootPane.setDefaultButton(botonEnvio);
        l=new Lectura(conversacion,in);
        l.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        conversacion = new javax.swing.JTextArea();
        zonaEscritura = new javax.swing.JTextField();
        botonEnvio = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 157, 255));

        conversacion.setColumns(20);
        conversacion.setEditable(false);
        conversacion.setRows(5);
        jScrollPane1.setViewportView(conversacion);

        botonEnvio.setText("Enviar");
        botonEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnvioActionPerformed(evt);
            }
        });

        botonCerrar.setText("Cerrar ventana");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botonCerrar)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(zonaEscritura, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(botonEnvio))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zonaEscritura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEnvio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnvioActionPerformed
       mensaje=zonaEscritura.getText();
       conversacion.setText(conversacion.getText()+usuario+" dice: "+mensaje+"\n");
       out.println(usuario+" dice: "+mensaje);
       zonaEscritura.setText("");
    }//GEN-LAST:event_botonEnvioActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        out.println(usuario+" ha abandonado la conversación");
        this.hide();
    }//GEN-LAST:event_botonCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonEnvio;
    private javax.swing.JTextArea conversacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField zonaEscritura;
    // End of variables declaration//GEN-END:variables

    public class PresionarTecla extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode()==KeyEvent.VK_ENTER){
                botonEnvioActionPerformed(null);
            }
        }
    }

}
