import classes.Dice;

public class Main {
   public static void dices() {
      Dice dice1 = new Dice();
      Dice dice2 = new Dice();
      dice1.run();
      dice2.run();
      System.out.println(dice1.number);
      System.out.println(dice2.number);
   }

   public static void multiThreadingTest() throws InterruptedException {
      long startTime = System.currentTimeMillis(), finishTime;

      final double[] sum = {0};

      for (double i = 0; i < 2e10; i++) {
         sum[0] += i;
      }
      finishTime = System.currentTimeMillis();

      System.out.println("1-thread test: " + sum[0]);
      System.out.println(finishTime - startTime);


      System.out.println("\n---------------------------------\nMultithread test:\n");

      final double[] sum2 = {0};
      final double[] sum3 = {0};
      final double[] sum4 = {0};
      final double[] sum5 = {0};

      Thread thread1 = new Thread(new Runnable() {
         @Override
         public void run() {
            for (double i = 0; i < 1e10 / 2; i++) {
               sum2[0] = i;
            }
         }
      });

      Thread thread2 = new Thread(new Runnable() {
         @Override
         public void run() {
            for (double i = 1e10 / 2; i < 2e10 / 2; i++) {
               sum3[0] = i;
            }
         }
      });

      Thread thread3 = new Thread(new Runnable() {
         @Override
         public void run() {
            for (double i = 2e10 / 2; i < 2e10 / 2 + 1e10 / 2; i++) {
               sum4[0] = i;
            }
         }
      });


      Thread thread4 = new Thread(new Runnable() {
         @Override
         public void run() {
            for (double i = 2e10 / 2 + 1e10 / 2; i < 2e10; i++) {
               sum5[0] = i;
            }
         }
      });

      startTime = System.currentTimeMillis();
      thread1.setPriority(Thread.MAX_PRIORITY);
      thread1.start();
      thread2.setPriority(Thread.MIN_PRIORITY);
      thread2.start();
      thread3.setPriority(Thread.NORM_PRIORITY);
      thread3.start();
      thread4.start();

      long counter = 0;
      while (thread1.isAlive() && thread2.isAlive() && thread3.isAlive() && thread4.isAlive()) {
         Thread.sleep(10);
         counter++;
      }

      double sum6 = sum2[0] + sum3[0] + sum4[0] + sum5[0];

      finishTime = System.currentTimeMillis();

      System.out.println(sum6);
      System.out.println(finishTime - startTime);
      System.out.println("Checks: " + counter);
   }

   public static void main(String[] args) throws InterruptedException {
      // ChickenVoice.go();
      // NetGet.getResults();
      // dices();
      // multiThreadingTest();
   }
}

