package practica1ta;

/*
 * ProtocoloDirectorio.java
 *
 * Created on 18 de marzo de 2006, 3:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author jjramos
 */

//
// Clase padre del protocolo de directorio implementado.
// Especifica los formatos de mensajes del protocolo y otras
// operaciones comunes. 
// 
public class ProtocoloDirectorio {
    
    static final int errorEnRegistro=1;
    
    /** Creates a new instance of ProtocoloDirectorio */
    public ProtocoloDirectorio() {
    }
    
    String mensajeBienvenidaCliente(String texto){
        
        return "ClienteDirectorio 1.0 jjramos "+texto;
    }
    String mensajeSolicitudRegistro(String login, String password,String nombre,String direccion){
        String mensaje;
        mensaje="REGISTRAR "+login+" "+password+" "+nombre+" "+direccion;
        return mensaje;
    }
    String mensajeRespuestaRegistroAceptado(String texto){
        String mensaje;
        mensaje="200 "+texto;
        return mensaje;
    }
    
    String mensajeRespuestaUsuarioIncorrecto(String texto){
        String mensaje;
        mensaje="400 "+texto;
        return mensaje;
    }

    String mensajeSolicitudListaContactos(){
        String mensaje;
        mensaje="LISTARCONTACTOS";
        return mensaje;
    }
    String mensajeRespuestaListaContactos(String []lista){
        String mensaje;
        
        mensaje="200 LISTADO "+lista.length;
        for(int i=0;i<lista.length;i++){
            mensaje=mensaje+" "+lista[i];
        }
       
        return mensaje;
    }
    
    String mensajeSolicitudAnadirContacto(String contacto){
        String mensaje;        
        mensaje="ANADIRCONTACTO "+contacto;
        return mensaje;
    }
    
    String mensajeRespuestaAnadirContactoAceptado(String texto){
        String mensaje;
        mensaje="OK "+texto;
        return mensaje;
    }
    
    String mensajeRespuestaAnadirContactoDesconocido(String texto){
        String mensaje;
        mensaje=" "+texto;
        return mensaje;
    }
    
    String mensajeSolicitudEliminarContacto(String contacto){
            return "ELIMINAR "+contacto;
    }
    
    String mensajeRespuestaEliminarContactoDesconocido(String contacto){
        return "400 DESCONOCIDO "+contacto;
    }
    
    String mensajeRespuestaEliminarContactoAceptado(String contacto){
        return "200 OK";
    }
    
    String mensajeSolicitudLocalizarContacto(String contacto){
        return "LOCALIZAR "+contacto;
    }
    String mensajeRespuestaLocalizarContacto(String contacto,String localizacion){
        return "200 "+localizacion;
    }
    
    String mensajeRespuestaLocalizarContactoDesconocido(String contacto){
        return "400 "+contacto;
    }
    
    String mensajeSolicitudCerrarSesion(){
        return "CERRAR";
    }
    
    String mensajeRespuestaCerrarSesion(String mensaje){
        return "200 OK "+mensaje;
    }
    
    String mensajeAvisoRegistro(String contacto){
        return "AVISO "+contacto;
    }
}
