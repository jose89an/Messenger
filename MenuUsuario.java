/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuUsuario.java
 *
 * Created on 07-abr-2010, 13:08:17
 */

package practica1ta;

import java.io.*;
import java.util.logging.*;

/**
 *
 * @author Jose
 */
public class MenuUsuario extends javax.swing.JFrame {

    private String usuario;
    private BufferedReader in;
    private PrintWriter out;

    /** Creates new form MenuUsuario */
    public MenuUsuario(String usuario, BufferedReader in, PrintWriter out) {
        this.usuario=usuario;
        this.in=in;
        this.out=out;
        initComponents();

        HebraServ h=new HebraServ(usuario,9091);
        h.start();
    }

    public String getUsuario(){
        return usuario;
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
        bIniConv = new javax.swing.JButton();
        bLocalizarUs = new javax.swing.JButton();
        bAnadirUs = new javax.swing.JButton();
        bEliminarUs = new javax.swing.JButton();
        bObtenerLista = new javax.swing.JButton();
        bCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(191, 223, 255));

        bIniConv.setText("Iniciar Conversación");
        bIniConv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniConvActionPerformed(evt);
            }
        });

        bLocalizarUs.setText("Localizar Usuario");
        bLocalizarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLocalizarUsActionPerformed(evt);
            }
        });

        bAnadirUs.setText("Añadir Usuario");
        bAnadirUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnadirUsActionPerformed(evt);
            }
        });

        bEliminarUs.setText("Eliminar Usuario");
        bEliminarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarUsActionPerformed(evt);
            }
        });

        bObtenerLista.setText("Obtener Lista de Contactos");
        bObtenerLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bObtenerListaActionPerformed(evt);
            }
        });

        bCerrarSesion.setText("Cerrar Sesión");
        bCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarSesionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Californian FB", 1, 36));
        jLabel1.setText("Bienvenido, "+this.getUsuario());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bObtenerLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bIniConv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bLocalizarUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bAnadirUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bEliminarUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bIniConv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bLocalizarUs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAnadirUs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bEliminarUs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bObtenerLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCerrarSesion)
                .addGap(25, 25, 25))
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

    private void bCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarSesionActionPerformed
        this.hide();
        new Registro().setVisible(true);
    }//GEN-LAST:event_bCerrarSesionActionPerformed

    private void bAnadirUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnadirUsActionPerformed
        new AnadirUsuario(usuario,in,out).setVisible(true);
    }//GEN-LAST:event_bAnadirUsActionPerformed

    private void bEliminarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarUsActionPerformed
        new EliminarUsuario(usuario,in,out).setVisible(true);
    }//GEN-LAST:event_bEliminarUsActionPerformed

    private void bLocalizarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLocalizarUsActionPerformed
        new LocalizarUsuario(usuario,in,out).setVisible(true);
    }//GEN-LAST:event_bLocalizarUsActionPerformed

    private void bObtenerListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bObtenerListaActionPerformed
        new ListarContactos(usuario,in,out).setVisible(true);
    }//GEN-LAST:event_bObtenerListaActionPerformed

    private void bIniConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniConvActionPerformed
        new InicioCharla(usuario).setVisible(true);
    }//GEN-LAST:event_bIniConvActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnadirUs;
    private javax.swing.JButton bCerrarSesion;
    private javax.swing.JButton bEliminarUs;
    private javax.swing.JButton bIniConv;
    private javax.swing.JButton bLocalizarUs;
    private javax.swing.JButton bObtenerLista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
