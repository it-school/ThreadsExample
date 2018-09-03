import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect("https://google.com").timeout(30000).get();
                    String text = document.text();
                    System.out.println(text);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++){
            list.add(i);
        }

        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println("Information written");
    }
}

