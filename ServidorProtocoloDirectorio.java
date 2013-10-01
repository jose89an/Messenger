package practica1ta;

/*
 * ServidorProtocoloDirectorio.java
 *
 * Created on 18 de marzo de 2006, 7:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

//
// Clase ServidorProtocoloDirectorio.
// Implementa la parte del protocolo del servicio de directorio referente al servidor.
//


import java.io.*;
/**
 *
 * @author jjramos
 */


public class ServidorProtocoloDirectorio extends ProtocoloDirectorio {
    
        String nombre;
        PrintWriter out;
        BufferedReader in;
        int estado;
  
        // Estados del protocolo (ver el disenio de la ma'quina de estados)
        static final int estadoInicial=0;
        static final int estadoSaludado=1;
        static final int estadoRegistrado=2;
        
        // Co'digos de las solicitudes:
        public static final int   solicitudRegistrar=2;
        public static final int   solicitudAnadir=3;         
        public static final int   solicitudListado=4; 
        public static final int   solicitudCerrar=5; 
        public static final int   solicitudEliminar=6;  
        public static final int  solicitudLocalizar=7;
        
        // Variables temporales que contienen los datos de la solicitud en curso:
        String solicitudLogin;
        String solicitudContrasenia;
        String solicitudApodo;
        String solicitudDireccion;
        int solicitudPuerto;
        
    /** Creates a new instance of ServidorProtocoloDirectorio */
    public ServidorProtocoloDirectorio( String n, BufferedReader in_, PrintWriter out_) {
        in=in_;
        out=out_;
        nombre=n;
        
        estado=estadoInicial;
    }
    
    //
    // Me'todo que implementa la interpretacio'n de los mensajes recibidos por la 
    // conexio'n, las transiciones y los estados del protocolo desde el punto de 
    // vista del servidor. 
    //  Devuelve un co'digo de mensaje recibido, que la clase "servidor" utiliza para 
    // realizar la operacio'n que requiera.
    // 
    int recibirPeticion(){
        int error=0;
        String mensaje;
        String [] palabras;
        
        try {   
            // Seg?n el estado actual, se interpreta el mensaje;
            mensaje=in.readLine();
            palabras=mensaje.split(" ");
            
            switch(estado){
                case estadoInicial:
                    
                    // se obtiene el mensaje de bienvenida del cliente:
                    System.out.println(nombre+": se recibe saludo ("+mensaje+")");            
                    estado=estadoSaludado;
                    
                    break;
                    
                case estadoSaludado:
                    
                    // Ojo, no se comprueba el n?mero de campos, as? que es
                    // "Explotable
                    solicitudLogin=new String(palabras[1]);
                    solicitudContrasenia=new String (palabras[2]);
                    solicitudApodo=new String (palabras[3]);
                    solicitudDireccion=new String (palabras[4]);
                    //solicitudPuerto=Integer.valueOf(palabras[5]);
                    
                    // Si se trata del registro:
                    if(palabras[0].compareTo("REGISTRAR")==0){
                        System.out.println("Registrando a "+palabras[1]+"...");
                    } else {
                        System.err.println("Petici?n incorrecta: "+mensaje);
                    }
                    error=solicitudRegistrar;
                    
                    break;
                    
                case estadoRegistrado:
                    
                    // Seg?n el tipo de solicitud que se haga...
                    if(palabras[0].compareTo("ANADIRCONTACTO")==0){
                        
                        // Comprobamos que el otro usuario existe:
                        error=solicitudAnadir;
                        solicitudLogin=palabras[1];
                    } else if(palabras[0].compareTo("LISTARCONTACTOS")==0){
                        // enviar la lista de contactos:
                        error=solicitudListado;
                    } else if(palabras[0].compareTo("CERRAR")==0){
                        // Cerrar la conexi?n:
                        error=solicitudCerrar;
                    } else if(palabras[0].compareTo("ELIMINAR")==0){
                        // Eliminar contacto
                        error=solicitudEliminar;
                        solicitudLogin=palabras[1];
                    } else if(palabras[0].compareTo("LOCALIZAR")==0){
                        // Devolver la direccion del usuario especificado:
                        error=solicitudLocalizar;
                        solicitudLogin=palabras[1];
                    }
                    
                    break;
                default:
                    error=-1;
                    break;
            };
        } catch (IOException ex) {
            //ex.printStackTrace();
            error=-2;
        }
        
        
        return error;
    }

        
    // Envi'a mensaje de confirmacio'n del registro
    int confirmarRegistro(String login){
        int error=0;
        
        out.println(mensajeRespuestaRegistroAceptado("Has sido registrado."));
        estado=estadoRegistrado;
        return error;
    }
    
    // Envi'a mensaje de confirmacio'n de contacto aniadido:
    int responderAdicionAceptada(String login){
        int error=0;
        out.println(mensajeRespuestaAnadirContactoAceptado("El contacto "+login+" ha sido añadido"));
        estado=estadoRegistrado;
        return error;
    }
    
     // Envi'a mensaje de denegacio'n de contacto aniadido:
     int responderAdicionDenegada(String login){
        int error=0;
        out.println(mensajeRespuestaAnadirContactoDesconocido("El contacto "+login+" no existe"));
        estado=estadoRegistrado;
        return error;
    }
}
