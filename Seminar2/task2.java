package Java.Seminar2;

import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;



/*
 * Seminar2 Task2
 * Реализовать простой калькулятор
 * с логироваием
 */

public class task2 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(task2.class.getName());
        FileHandler fh = new FileHandler("log_task2.txt");
        logger.addHandler(fh);
        
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        String oper_sign = ""; 
        String cont_count = "";
        Scanner iScanner = new Scanner(System.in);
        do {
            try {
                System.out.print("Input first operand: ");
                double f_numb = iScanner.nextDouble();
                logger.log(Level.INFO,"the first operand: " + f_numb);
                System.out.print("Input second operand: ");
                double s_numb = iScanner.nextDouble();
                logger.log(Level.INFO,"the second operand: " + s_numb);
                System.out.print("Input operation sign(+,-,/,*,**,sqrt): ");
                oper_sign = iScanner.next();
                logger.log(Level.INFO,"the operation is: " + oper_sign);

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
                System.out.println(f_numb + " " + oper_sign + " " + s_numb + " = " + result);
                logger.log(Level.INFO,"the operation result is: " + result); 

                System.out.print("Continue counting? (Y - yes, N - no): ");
                cont_count = iScanner.next();
                if (cont_count.equalsIgnoreCase("N"))
                        System.out.println("Job is done!");

            } catch (Exception e) {
                System.out.println("Error! Check up your operands!");
                logger.log(Level.WARNING, "The operation was interrupted by an error.");
                cont_count = "N"; 
            }
        } 
        while (!cont_count.equalsIgnoreCase("N"));   
        iScanner.close();
        logger.log(Level.WARNING, "Job is done!");
        fh.close();
    }
    
}
