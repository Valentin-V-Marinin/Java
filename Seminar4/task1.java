package Java.Seminar4;

/*
* Seminar4 Task1
* Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
*/

import java.util.*;

public class task1 {
    public static void main(String[] args) {

        final int NUMBER = 7;
        LinkedList<Integer> Something = new LinkedList<>();
        Random r = new Random();

        for (int i = 0; i < NUMBER; i++) {
            Something.add(r.nextInt(-100,101));
        }
        System.out.println(Something);


        for (int i = 0; i < NUMBER; i++) {
            Something.add(i, Something.removeLast());
        }
        System.out.println(Something);

    }
}