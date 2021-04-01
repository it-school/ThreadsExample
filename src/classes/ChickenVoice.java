package classes;

public class ChickenVoice   //Класс с методом main()
{
    static EggVoice eggOpinion;   //Побочный поток

    public static void go() {
        eggOpinion = new EggVoice();   //Создание потока
        System.out.println("Спор начат...");
        eggOpinion.start();         //Запуск потока

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);   //Приостанавливает поток на 1 секунду
            } catch (InterruptedException e) {
            }
            System.out.println("курица!");
        }

        //Слово «курица» сказано 5 раз

        if (eggOpinion.isAlive())   //Если оппонент ещё не сказал последнее слово
        {
            try {
                eggOpinion.join();   //Подождать пока оппонент закончит высказываться.
            } catch (InterruptedException e) {
            }

            System.out.println("Первым появилось яйцо!");
        } else   //если оппонент уже закончил высказываться
        {
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }
}

