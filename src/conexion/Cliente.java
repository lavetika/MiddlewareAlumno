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
public class Cliente {

    private final GUIObserver observer;

    public Cliente(GUIObserver observer) {
        this.observer = observer;
    }

    public void enviar(String contenido) {
        OutputStream out = null;
        try {
            Socket socket = new Socket("127.0.0.1", 9000);
            out = socket.getOutputStream();

            byte[] bytes = serializar(contenido);

            System.out.println("Enviando: " + contenido);

            out.write(bytes);
            out.flush();

            InputStream in = socket.getInputStream();
            bytes = new byte[esperarDatos(in)];
            in.read(bytes);

            String recibido = deserializar(bytes);
            notificar(recibido);

            out.close();
            in.close();
            socket.close();
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
}
