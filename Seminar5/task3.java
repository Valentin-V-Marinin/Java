package Java.Seminar5;

import java.util.Arrays;
import java.util.Random;

/*
 * Seminar5 Task3
 * heap sort - пирамидальная сортировка
 */

public class task3 {
    public void sort(int arr[])
    {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        System.out.print("[");
        for (int i=0; i<n; ++i) {
            if (i==n-1) System.out.print(arr[i] + "]");
            else System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }


    public static void main(String args[])
    {
        Random r = new Random();
        int [] array = new int [12];
        int n = array.length;

        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(-100,101);
        }
        System.out.println("source array");
        System.out.println(Arrays.toString(array));

        task3 ob = new task3();
        ob.sort(array);

        System.out.println("result array");
        printArray(array);
    }

}
