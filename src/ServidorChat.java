import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(4000);
        Socket socket = serverSocket.accept();

        SendChat enviar = new SendChat(socket);
        enviar.start();

        RecieveChat recibir = new RecieveChat(socket);
        recibir.start();

        enviar.join();
        socket.close();

    }
}
