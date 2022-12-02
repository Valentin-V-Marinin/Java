package Java.Seminar3;

/*
 * Seminar3 Task2
 * Пусть дан произвольный список целых чисел, удалить из него четные числа
 */

import java.util.ArrayList;
import java.util.Random;


public class task2 {
    public static void main(String[] args) {
        final int NUMBER = 21;
        Random r = new Random();
        ArrayList<Integer> Odd = new ArrayList<>();

        for (int i = 0; i < NUMBER; i++) {
            Odd.add(r.nextInt(-100,100));
        }
        System.out.println(Odd);

        for (int i = NUMBER-1; i > -1; i--) {
            if (Odd.get(i)%2==0) Odd.remove(i);
        }
        System.out.println(Odd);

    }
}
