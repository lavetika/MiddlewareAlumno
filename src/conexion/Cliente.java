package conexion;

import gui.GUIObserver;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Invitado
 */
public class Cliente implements Framer{

    private static final int LONGITUD_ENTRADA=25;
    private static final int LONGITUD_SALIDA=15;
    private final GUIObserver observer;

    public Cliente(GUIObserver observer) {
        this.observer = observer;
    }

    public void enviar(String contenido) {
        System.out.println("El sistema Alumnos esta conectado al servidor.");
        System.out.println("----");
        OutputStream out = null;
        try {
            Socket socket = new Socket("127.0.0.1", 9000);
            out = socket.getOutputStream();

            byte[] bytes = serializar(contenido);

            System.out.println("Enviando: " + contenido);
            System.out.println("----");

            frameMsgLength(bytes,out);   
            
//            out.write(bytes);
//            out.flush();

            InputStream in = socket.getInputStream();
            bytes = nextMsgLength(in);

            String recibido = deserializar(bytes);
            System.out.println("Recibido: " + recibido);
            System.out.println("----");
            notificar(recibido);

            out.close();
            in.close();
            socket.close();
            System.out.println("El sistema Alumnos recibio la información y se desconectó del servidor.");
            System.out.println("----");
        } catch (Exception ex) {
            System.out.println("Ocurrió un error: " + ex.getMessage());
        }
    }
    
    

    private int esperarDatos(InputStream in) throws IOException {

        int tam;
        while ((tam = in.available()) == 0) {
            if (tam > 0) {
                break;
            }
        }
        return tam;
    }
    
    private static byte[] serializar(String cadena) throws IOException {
        return cadena.getBytes();
    }

    private static String deserializar(byte[] datos) throws IOException, ClassNotFoundException {
        return new String(datos, StandardCharsets.UTF_8);
    }

    private void notificar(String contenido) {
        observer.update(contenido);
    }

    @Override
    public void frameMsgLength(byte[] mensaje, OutputStream out) throws IOException {
        if(mensaje.length!=LONGITUD_SALIDA){
            throw new IOException("El tamaño del mensaje no es de la longitud establecida: "+LONGITUD_SALIDA);
        }
        
        out.write(mensaje);
        out.flush();
    }

    @Override
    public byte[] nextMsgLength(InputStream in) throws IOException {
        byte[] salida=new byte[LONGITUD_ENTRADA];
        in.read(salida);
        return salida;
    }
}
