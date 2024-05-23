import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendChat extends Thread {
    Socket socket;

    public SendChat (Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            Scanner scanner= new Scanner(System.in);

            while (true){
                String palabra = scanner.nextLine();
                printWriter.println(palabra);
                printWriter.flush();
                if (palabra.equals("salir"))
                    System.exit(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
