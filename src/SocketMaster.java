import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by paul thomas on 24.04.2016.
 */
class SocketMaster {

    public static void main(String[] args) throws IOException{
        final int PORTNR = 1250;

        ServerSocket serverSocket = null;
        Socket socket = null;
        ServerSocket master = new ServerSocket(PORTNR);

        System.out.println("Log for Mastersite, now we wait");



        while (true) {
            Socket connection = master.accept(); // waits for contact
            new ThreadForMultipleClients(connection).start();

        }








    }
}
