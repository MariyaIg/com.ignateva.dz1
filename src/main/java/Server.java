import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(Util.PORT);
                while (true) {
                    Socket socket =serverSocket.accept();
                    System.out.println(socket.getInetAddress().getHostName()+"connected");

                    ServerThread serverThread = new ServerThread(socket);
                    serverThread.start();


                }

            } catch (IOException e)
        {
            e.printStackTrace();
        }



    }
}

