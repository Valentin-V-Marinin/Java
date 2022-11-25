package Java.Seminar1;

import java.util.Scanner;


/*
 * Seminar1 Task3
 * Реализовать простой калькулятор
 */

public class task3 {
    public static void main(String[] args) {
        
        String oper_sign = "";
        Scanner iScanner = new Scanner(System.in);
        do {
            try {
                System.out.print("Input first operand: ");
                double f_numb = iScanner.nextDouble();
                System.out.print("Input second operand: ");
                double s_numb = iScanner.nextDouble();
                System.out.print("Input operation sign(+,-,/,*,**,sqrt or q-quit): ");
                oper_sign = iScanner.next();

                double result = 0;
                switch (oper_sign) {
                    case "+":
                        result = f_numb + s_numb;
                        break;
                    case "-":
                        result = f_numb - s_numb;
                        break;
                    case "/":
                        result = f_numb / s_numb;
                        break;
                    case "*":
                        result = f_numb * s_numb;
                        break;
                    case "**":
                        result = Math.pow(f_numb, s_numb);
                        break;
                    case "sqrt":
                        result = Math.round(Math.pow(f_numb, 1.0/s_numb));
                        break;
                    default:
                        result = 0;
                        break;
                }
                if (oper_sign.equalsIgnoreCase("q"))
                    System.out.println("Job is done!");
                else 
                    System.out.println(f_numb + " " + oper_sign + " " + s_numb + " = " + result);

            } catch (Exception e) {
                System.out.println("Error! Check operands!");
                oper_sign = "q"; 
            }
        } 
        while (!oper_sign.equalsIgnoreCase("q"));   
        iScanner.close();

    }
}
