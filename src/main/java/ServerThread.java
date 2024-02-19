import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ServerThread extends Thread{

    private BufferedReader reader;
    private PrintStream printStream;
    private InetAddress address;
    private Quotes quotes;
    public ServerThread(Socket socket) {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream= new PrintStream(socket.getOutputStream());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        address = socket.getInetAddress();
    }

    @Override
    public void run() {
        int counter = 1;
        String message;
        Random rand = new Random();
        Quotes quotes = new Quotes();
        LocalTime timein = LocalTime.now();
        ArrayList<String> user_quotes = new ArrayList<>();
        Logs logs;
        try {
            while ((message = reader.readLine()) != null) {
                if ("request".equals(message)) {
                    int choice = rand.nextInt(quotes.list.size());
                    printStream.println("Цитата " + counter +" "+ quotes.list.get(choice));
                    user_quotes.add(quotes.list.get(choice));
                System.out.println("цитата " + counter + "from" + address.getHostName());
                counter++;
                }
                else if ("exit".equals(message)){
                    printStream.println("до новых встреч ");
                   break;
                }

            }
            LocalTime timeout = LocalTime.now();
            logs = new Logs(address.getHostName(),timein,timeout, user_quotes);
            logs.print();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

        private void disconnect() {
            if (printStream != null){
                printStream.close();
        }
        try {
            if (reader !=null){
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();

    }



    }
}
