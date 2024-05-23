import java.io.IOException;
import java.net.Socket;

public class ClienteChat {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 4000);
        SendChat enviar = new SendChat(socket);
        enviar.start();

        RecieveChat recibir = new RecieveChat(socket);
        recibir.start();

        enviar.join();
        socket.close();
    }
}
