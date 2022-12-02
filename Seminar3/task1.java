package Java.Seminar3;

import java.util.Arrays;
import java.util.Random;

/*
 * Seminar3 Task1 
 * Реализовать алгоритм сортировки слиянием
 */

public class task1 {
    public static void main(String[] args) {
        final int NUMBER = 12;
        Random r = new Random();
        int [] stat_source = new int [NUMBER];

        for (int i = 0; i < NUMBER; i++) {
            stat_source[i] = r.nextInt(-100, 100);
        }
        System.out.println(Arrays.toString(stat_source));

        int [] stat_result  = Arrays.copyOf(sortArray(stat_source),NUMBER);
        System.out.println(Arrays.toString(stat_result));
    }

    public static int [] sortArray(int[] arrayA){
        if (arrayA == null) {
            return null;
        }

        if (arrayA.length < 2) {
            return arrayA;
        }

        int [] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        arrayB = sortArray(arrayB);
        arrayC = sortArray(arrayC);

        return mergeArray(arrayB, arrayC);
    }

    public static int [] mergeArray(int [] arrayA, int [] arrayB) {

        int[] arrayC = new int[arrayA.length + arrayB.length];

        int i=0, j=0;
        for (int k=0; k<arrayC.length; k++) {

            if (i > arrayA.length-1) {
                int a = arrayB[j];
                arrayC[k] = a;
                j++;
            }
            else if (j > arrayB.length-1) {
                int a = arrayA[i];
                arrayC[k] = a;
                i++;
            }
            else if (arrayA[i] < arrayB[j]) {
                int a = arrayA[i];
                arrayC[k] = a;
                i++;
            }
            else {
                int b = arrayB[j];
                arrayC[k] = b;
                j++;
            }
        }
        return arrayC;
    }

}
