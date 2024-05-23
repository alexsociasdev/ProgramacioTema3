import java.io.IOException;
import java.net.*;

public class ServidorRepaso {
    public static void main(String[] args) throws IOException {
        byte[] mensaje = new byte[1024];

        DatagramSocket recibir = new DatagramSocket(3500);
        recibir.setReuseAddress(true);

        DatagramPacket packet = new DatagramPacket(mensaje, mensaje.length);
        recibir.receive(packet);

        String datos = new String(packet.getData());
        System.out.println("Menasaje: " + datos);

        if(datos.length() > 0){
            String recibido = "Mensaje recibido";
            byte [] recibytes = recibido.getBytes();
            DatagramSocket enviar = new DatagramSocket(new InetSocketAddress(0));
            InetAddress local = InetAddress.getLocalHost();
            int port = 3501;
            InetSocketAddress destino = new InetSocketAddress(local, port);
            DatagramPacket packet1 = new DatagramPacket(recibytes, recibytes.length, destino);
            enviar.send(packet1);
        }



        recibir.close();
    }
}
