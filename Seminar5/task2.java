package Java.Seminar5;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Seminar5 Task2
 * В списке сотрудников найти повторяющиеся имена, посчитать их и 
 * вывести список в порядке убывания "популярности"
 */

public class task2 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> emp_list = new ArrayList<String>();
        get_names(emp_list);
        count_names(emp_list);
    }

    public static void get_names(ArrayList<String> emp) throws IOException {
        String path = "C:\\GB\\HW\\employees_list.txtt";
        Scanner sc = new Scanner(new FileReader(path));//.useDelimiter(",\\s*");

        String str;

        while (sc.hasNext()) {
            str = sc.next();
            emp.add(str);
        }
        sc.close();
    }

    public static void count_names(ArrayList<String> emp) {
        Map<String, Integer> names = new HashMap<>();

        for (int i = emp.size()-1 ; i > 0; i=i-2) {
            emp.remove(i);
        }

        int idx_pos = 0; int count = 0; String name = "";
        while (!emp.isEmpty()) {
            name = emp.get(idx_pos);
            for (int i = idx_pos; i < emp.size(); i++) {
                if (emp.get(i).equals(name)) count++;
            }

            names.put(name, count);

            for (int i = emp.size()-1 ; i >= 0; i--) {
                if (emp.get(i).equals(name)) emp.remove(i);
            }
            count = 0;
        }

        for (int i = names.size(); i>0; i--) {
            for (var n : names.entrySet()) {
                if (n.getValue().equals(i)) System.out.printf("[%s: %s]\n", n.getKey(), n.getValue());
            }
        }
    }
}