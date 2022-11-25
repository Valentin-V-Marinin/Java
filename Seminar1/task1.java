package Java.Seminar1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Seminar1 Task1
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */
public class task1 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Input triangle/factorial number: ");
        int count = iScanner.nextInt();
        
        int arr_t[] = new int[count]; int arr_f[] = new int[count]; 
        int count_t = 0; int count_f = 1;
    
        for (int i = 1; i <= count; i++) {
            count_t += i; count_f *= i;
            arr_t[i-1] = count_t;   
            arr_f[i-1] = count_f;
        }

        System.out.println(Arrays.toString(arr_t) + " - triangle numbers list");
        System.out.println(Arrays.toString(arr_f) + " - factorial numbers list");
        iScanner.close();
    }
}
