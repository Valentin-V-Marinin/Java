package Java.Seminar4;

/*
 * Seminar4 task2
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди, 
 * dequeue() - возвращает первый элемент из очереди и удаляет его, 
 * first() - возвращает первый элемент из очереди, не удаляя.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> some_queue = new LinkedList<>();
        int number = 0;
        int q_member = 0;

        try{
            while(number != 4){
                menu();
                number = sc.nextInt();
                switch(number){
                    case 1:
                        enqueue(some_queue, sc);
                        break;
                    case 2:
                        q_member = dequeue(some_queue);
                        System.out.println(q_member);
                        System.out.println(some_queue);
                        break;
                    case 3:
                        q_member = first(some_queue);
                        System.out.println(q_member);
                        System.out.println(some_queue);
                        break;
                    case 4:
                        System.out.println("Конец работы.");
                        break;
                    default:
                        System.out.println("Ошибка! Конец работы.");
                        number = 4;
                        break;
                }
            } 
        } catch (Exception e) { System.out.println("Ошибка! Введенное значение не цифра/число.");}
        
    }

    public static void menu() {
        System.out.println("Выберите действие: \n"+
                "1 - добавть элемент в очередь\n"+
                "2 - удалить и вернуть первый элемент в очереди\n"+
                "3 - вернуть первый элемент в очереди\n"+
                "4 - завершить работу\n ?:"
        );
    }

    public static void enqueue(Queue<Integer> sq, Scanner sc) {
        System.out.println("Введите новый элемент очереди: ");
        int new_member = sc.nextInt();
        sq.offer(new_member);
        System.out.println(sq);
    }

    public static int dequeue(Queue<Integer> sq) {
        return sq.poll();
    }

    public static int first(Queue<Integer> sq) {
        return sq.peek();
    }

}