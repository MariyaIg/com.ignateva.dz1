public class Main {
    public static void main(String[] args) {

        Quotes qoutes= new Quotes();

        for (int i = 1; i <qoutes.list.size(); i++) {

            System.out.println(qoutes.list.get(i));
        }
    }
}