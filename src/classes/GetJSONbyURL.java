package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GetJSONbyURL {
   public static String load(String urlString) throws IOException {
      StringBuilder jsonIn = new StringBuilder();
      InputStream is = null;
      is = new URL(urlString).openStream();
      try {
         BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

         int cp;
         while ((cp = rd.read()) != -1) {
            jsonIn.append((char) cp);
         }
      } finally {
         is.close();
      }

      return jsonIn.toString();
   }
}
