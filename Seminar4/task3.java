package Java.Seminar4;

/*
 * Seminar4 task3
 * Написать программу, определяющую правильность расстановки скобок в выражении.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = "";

        while (true) {
            System.out.println("Введите выражение для оценки (stop - для выхода): ");
            expression = sc.next();
            if (expression.equals("stop"))
                break;
            else
                System.out.println(check_exp(expression));
        }
        sc.close();
    }

    public static boolean check_exp(String exp) {
        char[] parenthesis = new char[]{'(',')','[',']','{','}','<','>'};
        boolean result = true;

        for (int i = 0; i < parenthesis.length; i=i+2) {
                result = check_pair(exp, parenthesis[i],  parenthesis[i+1]);
                if (!result) break;;
        }
        return result;
    }

    public static boolean check_pair(String exp, char p_open, char p_close) {
        ArrayList<Integer> open = new ArrayList<>();
        ArrayList<Integer> close = new ArrayList<>();
        boolean result = true;

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i)==p_open) open.add(i);
            if (exp.charAt(i)==p_close) close.add(i);
        }

        if (open.size()==close.size()){
            for (int i = 0; i < open.size(); i++) {
                if (open.get(i) >= close.get(i)) {
                    result = false;
                    break;}
                else {
                    result = true; }
            }
        }
        else {
            result = false;}

        return result;
    }

}