package Java.Seminar3;

/*
 * Seminar3 Task3
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
 */


import java.util.ArrayList;
import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        final int NUMBER = 10;
        Random r = new Random();
        ArrayList<Integer> stat = new ArrayList<>();

        for (int i = 0; i < NUMBER; i++) {
            stat.add(r.nextInt(-100, 100));
        }
        System.out.println(stat);

        int max = 0;
        int min = 0;
        double sum = 0;
        int number = 0;

        for (int i = 0; i < stat.size(); i++) {
            if (i==0){
               max = stat.get(i); min = stat.get(i);
               sum = stat.get(i); number++;
            }
            else{
                if (stat.get(i)>max) max = stat.get(i);
                if (stat.get(i)<min) min = stat.get(i);
                sum += stat.get(i); number++;
            }
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + sum/number);
    }

}
