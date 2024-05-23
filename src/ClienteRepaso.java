import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClienteRepaso {
    public static void main(String[] args) throws IOException {
        byte [] bytesms = "hola".getBytes();
        DatagramSocket enviar = new DatagramSocket(new InetSocketAddress(0));
        InetAddress local = InetAddress.getLocalHost();
        int port = 3500;
        InetSocketAddress destino = new InetSocketAddress(local, port);

        DatagramPacket packet = new DatagramPacket(bytesms, bytesms.length, destino);
        enviar.send(packet);

        byte[] mensaje = new byte[1024];
        DatagramSocket recibir = new DatagramSocket(3501);
        recibir.setReuseAddress(true);
        DatagramPacket packet1 = new DatagramPacket(mensaje, mensaje.length);
        recibir.receive(packet1);
        String datos = new String(packet1.getData());
        System.out.println("recibido confirmación: " + datos);
        recibir.close();
        enviar.close();
    }
}
