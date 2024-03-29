import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int CLIENT_TIMEOUT = 1000;

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        try(
                Socket socket = new Socket(InetAddress.getLocalHost(), Util.PORT);
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            System.out.println("Получить случайную цитату (не более 5), нажмите 1 \n чтобы выйти, нажмите 0 ");
            for (int i=0; i<5;) {

                int number = scan.nextInt();
                if (number == 1) {
                    printStream.println("request");
                    System.out.println(reader.readLine());
                    Thread.sleep(CLIENT_TIMEOUT);
                    i++;
                    if (i==5) {
                        System.out.println("Ваш лимит на цитаты исчерпан");
                    }
                }
                else if (number == 0) {
                   printStream.println("exit");
                   System.out.println(reader.readLine());
                   break;
               }
           }
        } catch (IOException | InterruptedException e){
        e.printStackTrace();

        }
    }
}

