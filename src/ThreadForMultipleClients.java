import java.io.*;
import java.net.Socket;

/**
 * Created by paul thomas on 24.04.2016.
 */
class ThreadForMultipleClients extends Thread {
    protected Socket socket;

    public ThreadForMultipleClients(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run()  {
        try {

            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("Contact succesful");
            writer.println("Write here and i will reply");

            String onLine = bufferedReader.readLine(); // reads from client

            while (onLine != null) {
                System.out.println("Client wrote:\t" + onLine);
                writer.println("you Wrote:\t" + onLine);
                onLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
        }
    }
}