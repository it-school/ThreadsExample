package classes;

import java.util.Random;

public class Dice extends Thread {
   public byte number;

   @Override
   public void run() {
      Random random = new Random();

      for (long i = 0; i < 10000000000L; i++) {
         number = (byte) (1 + random.nextInt(5));
      }
   }
}