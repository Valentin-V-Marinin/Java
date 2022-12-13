import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class Main {
    public static void main(String[] args) throws IOException {

        try {
            Set<Notebook> notebooks = new HashSet<>();
            Map<Integer, String> user_criteria = new HashMap<>();
            fill_collection(notebooks);
            user_criteria.putAll(select_filters());
            select_notes(notebooks, user_criteria);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка! Проверьте правильность ввода цифровых/числовых значений.");
        }
    }

    public static void fill_collection(Set<Notebook> snb) {
        Notebook note1 = new Notebook();
        note1.setColor("black");
        note1.setModel("Asus");
        note1.setHdd(256);
        note1.setOzu(4);
        note1.setScreen(15);
        note1.setOs("Windows");
        note1.setPrice(25000.00);

        Notebook note2 = new Notebook();
        note2.setColor("gray");
        note2.setModel("Asus");
        note2.setHdd(512);
        note2.setOzu(8);
        note2.setScreen(17);
        note2.setOs("Windows");
        note2.setPrice(35000.00);

        Notebook note3 = new Notebook();
        note3.setColor("black");
        note3.setModel("HP");
        note3.setHdd(512);
        note3.setOzu(8);
        note3.setScreen(17);
        note3.setOs("Linux");
        note3.setPrice(38000.00);

        Notebook note4 = new Notebook();
        note4.setColor("red");
        note4.setModel("Acer");
        note4.setHdd(256);
        note4.setOzu(4);
        note4.setScreen(15);
        note4.setOs("Linux");
        note4.setPrice(30000.00);

        Notebook note5 = new Notebook();
        note5.setColor("gray");
        note5.setModel("Samsung");
        note5.setHdd(1024);
        note5.setOzu(12);
        note5.setScreen(17);
        note5.setOs("Windows");
        note5.setPrice(50000.00);

        Notebook note6 = new Notebook();
        note6.setColor("pink");
        note6.setModel("Apple");
        note6.setHdd(512);
        note6.setOzu(8);
        note6.setScreen(15);
        note6.setOs("MacOS");
        note6.setPrice(55000.00);

        Notebook note7 = new Notebook();
        note7.setColor("white");
        note7.setModel("Huawei");
        note7.setHdd(256);
        note7.setOzu(4);
        note7.setScreen(14);
        note7.setOs("Windows");
        note7.setPrice(20000.00);

        snb.add(note1);
        snb.add(note2);
        snb.add(note3);
        snb.add(note4);
        snb.add(note5);
        snb.add(note6);
        snb.add(note7);

    }

    public static Map<Integer, String> filters() {
        Map<Integer, String> criteria  = new HashMap<>();
        criteria.put(1, "объём ОЗУ");
        criteria.put(2, "объём HDD");
        criteria.put(3, "размер экрана");
        criteria.put(4, "цвет");
        criteria.put(5, "операционная система");
        criteria.put(6, "марка");
        criteria.put(7, "цена");

        for (var n : criteria.entrySet()) {
            System.out.printf("[%s: %s]\n", n.getKey(), n.getValue());
        }

        return criteria;
    }

    public static Map<Integer, String> select_filters() {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> user_criteria = new HashMap<>();
        Map<Integer, String> selected_criteria = new HashMap<>();
        user_criteria.putAll(filters());
        int user_choise = 0; String choice_value = "";
        boolean stop = false;

        while (!stop) {
            System.out.println("Выберите критерий из списка для отбора ноутбуков\n и " +
                    "введите цифру нужного критерия: ");
            user_choise = sc.nextInt();
            System.out.println("Введите значение (нижняя граница) для выбранного критерия: ");
            choice_value = sc.next();
            selected_criteria.put(user_choise, choice_value);

            System.out.println("Дополнительный критерий? (Y-да, N-нет): ");
            choice_value = sc.next();
            if (choice_value.toLowerCase().equals("n"))
                stop = true;
        }
        sc.close();
        return selected_criteria;
    }

    public static void select_notes(Set<Notebook> notebooks, Map<Integer, String> user_criteria) {
        Set<Notebook> result_selection  = new HashSet<>();
        System.out.println("================================================================================================");

        for (var nb : notebooks) {
            for (var n : user_criteria.entrySet()) {
                switch (n.getKey()) {
                    case 1:
                        if (Integer.parseInt(n.getValue()) <= nb.getOzu()) result_selection.add(nb);
                        break;
                    case 2:
                        if (Integer.parseInt(n.getValue()) <= nb.getHdd()) result_selection.add(nb);
                        break;
                    case 3:
                        if (Integer.parseInt(n.getValue()) <= nb.getScreen()) result_selection.add(nb);
                        break;
                    case 4:
                        if (n.getValue().toLowerCase().equals(nb.getColor().toLowerCase())) result_selection.add(nb);
                        break;
                    case 5:
                        if (n.getValue().toLowerCase().equals(nb.getOs().toLowerCase())) result_selection.add(nb);
                        break;
                    case 6:
                        if (n.getValue().toLowerCase().equals(nb.getModel().toLowerCase())) result_selection.add(nb);
                        break;
                    case 7:
                        if (Double.parseDouble(n.getValue()) <= nb.getPrice()) result_selection.add(nb);
                        break;
                    default:
                        break;
                }
            }
        }

        for (var n: result_selection) {
            System.out.println(n);
        }


    }
}