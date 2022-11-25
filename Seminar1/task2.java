package Java.Seminar1;

import java.util.ArrayList;

/*
 * Seminar1 Task2
 * Вывести все простые числа от 1 до 1000
*/

public class task2 {
    public static void main(String[] args) {
        ArrayList<Integer> simple_numbers = new ArrayList<>();
        simple_numbers.add(1);

        for (int i = 1; i < 1001; i++) {
            for (int j = 2; j <= i; j++) {
                if (i%j == 0) 
                    if (j==i) simple_numbers.add(i);
                    else break;
            } 
        }
        
        System.out.println(simple_numbers + " - simple numbers list");
    }
}
