/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1ta;

import java.io.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Jose
 */
public class Lectura extends Thread {
    JTextArea conversacion;
    BufferedReader in;

    public Lectura(JTextArea conversacion,BufferedReader in){
        this.conversacion=conversacion;
        this.in=in;
    }

    @Override
    public void run(){
        super.run();
        do{
            try {
                String message = in.readLine();
                conversacion.setText(conversacion.getText()+message+"\n");
            } catch (IOException ex) {
                Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(true);
    }

}
