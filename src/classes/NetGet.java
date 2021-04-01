package classes;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class NetGet {
   public static void getResults() throws InterruptedException {
      final String[] text = {""};
      ArrayList<String> list = new ArrayList<>();

      for (int version = 7; version <= 16; version++) {
         System.out.println("Thread for Java" + version);
         int finalI = version;

         new Thread(new Runnable() {
            public void run() {
               try {
                  System.out.println("https://www.google.com/search?q=java" + finalI);
                  Document document = Jsoup.connect("https://www.google.com/search?q=java" + finalI).timeout(30000).get();
                  text[0] = document.text();

               } catch (Exception ex) {
                  ex.printStackTrace();
               }
            }
         }).start();

         Thread.sleep(1000);
         list.add("" + finalI + ") " + text[0]);
      }

      for (String result : list) {
         System.out.println(result + System.lineSeparator());
      }
   }


}
