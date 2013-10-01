/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1ta;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class HebraServ extends Thread {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socketConexion;
    private ServerSocket socketDeEscucha;
    private String usuario;
    private int confirmacion;

    public HebraServ(String usuario,int puerto){
        this.usuario=usuario;
        try {
            socketDeEscucha = new ServerSocket(puerto);
        } catch (IOException ex) {
            Logger.getLogger(HebraServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getConfirmacionCharla(){
        return confirmacion;
    }

    public String getUsuario(){
        return usuario;
    }

    @Override
    public void run(){
        super.run();
        do{
            try {
                socketConexion = socketDeEscucha.accept();
                out = new PrintWriter(socketConexion.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socketConexion.getInputStream()));

                String palabras=in.readLine();
                String [] vMens=palabras.split(" ");
                String hablador=vMens[1];
                confirmacion=JOptionPane.showConfirmDialog(null, "¿Desea iniciar una conversación con "+hablador+"?","Ventana de confirmación",JOptionPane.YES_NO_OPTION);
                if(confirmacion==0){
                    out.println("CONFIRMO");
                    new VentanaCharla(usuario,in,out).setVisible(true);
                }
                else{
                    out.println("RECHAZO");
                }

            } catch (IOException ex) {
                Logger.getLogger(HebraServ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(true);
    }

}
