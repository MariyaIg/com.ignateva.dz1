import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

public class Logs {
    String user_host;
    LocalTime timeIn;
   LocalTime timeOut;
    ArrayList<String> user_quotes;

    public Logs(String user_host, LocalTime timeIn, LocalTime timeOut, ArrayList<String> user_quotes) {
        this.user_host = user_host;
        this.timeIn = timeIn;
        this.timeOut= timeOut;
        this.user_quotes =user_quotes;
    }

    public ArrayList<String> getUser_quotes() {
        return user_quotes;
    }

    public String getUser_host() {
        return user_host;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setUser_host(String user_host) {
        this.user_host = user_host;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    public void setUser_quotes(ArrayList<String> user_quotes) {
        this.user_quotes = user_quotes;
    }

    public void print()
    {
        System.out.println();
        System.out.println("host "+user_host+"," +
                "\n" +"время входа: "+timeIn.toString()+"," +
                "\n" + "время выхода: "+ timeOut.toString()+"," +
                "\n");
        for (int i = 0; i < user_quotes.size(); i++) {
            System.out.print(user_quotes.get(i));
            System.out.println();
        }

    }
}
