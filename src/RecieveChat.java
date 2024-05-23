import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class RecieveChat extends Thread {
    Socket socket;

    public RecieveChat (Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String palabra = bufferedReader.readLine();
                System.out.println("dice: " + palabra);
                if (palabra.equals("salir"))
                    System.exit(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
