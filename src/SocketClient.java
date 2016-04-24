import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by paul thomas on 24.04.2016.
 */
class SocketClient {
    public static void main(String[] args) throws IOException {
        final int PORTNR = 1250;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of computer Master");
        String master = scanner.nextLine();

        Socket connection = new Socket(master, PORTNR);
        System.out.println("connection successful");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);
        PrintWriter printWriter = new PrintWriter(connection.getOutputStream(), true);

        String innledning1 = bufferedReader.readLine();
        String innledning2 = bufferedReader.readLine();

        System.out.println(innledning1 + "\n" + innledning2);

        String oneLine = scanner.nextLine();
        while (!oneLine.equals("")){
            printWriter.println(oneLine);
            String response = bufferedReader.readLine();
            System.out.println("From master:\t" + response);
            oneLine = scanner.nextLine();
        }


    }
}
