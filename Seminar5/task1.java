package Java.Seminar5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.Long;

/*
 * Seminar 5   Task1
 * Реализовать структуру телефонной книги с помощью HashMap,
 * учитывая, что 1 человек может иметь несколько телефонов
 */



public class task1 {
    public static void main(String[] args) {
        Map<Long, String> phoneBook = new HashMap<Long, String>();
        Scanner sc = new Scanner(System.in);
        int menu = 1;
        System.out.println();

        try
        {    
            while (menu!=6)
            {
                System.out.println( "1 - show all numbers\n" + 
                                    "2 - add new record\n" + 
                                    "3 - edit record\n" + 
                                    "4 - delete record\n" + 
                                    "5 - select record\n" + 
                                    "6 - quit\n"
                                    );
                
                menu = sc.nextInt();

                switch (menu)
                {
                    case 1:
                        show_records(phoneBook);
                        break;
                    case 2:
                        add_record(phoneBook, sc);
                        break;
                    case 3:
                        edit_record(phoneBook, sc);
                        break;
                    case 4:
                        remove_record(phoneBook, sc);
                        break;
                    case 5:
                        select_record(phoneBook, sc);
                        break;
                    case 6:
                        menu = 6;
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Error! Incorrect choice!");
                        break;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error!");
        }
        finally
        {
            sc.close();
        }
        System.out.println("");
    }


    public static void add_record(Map<Long, String> pb, Scanner scn) {
        String quit = "c";
        long phone_number = 0;
        String fio = "";

        try
            {
            while (!quit.equals("q"))
                {
                System.out.println("Input new record, step 1 - place here phone number (11 digits max): ");
                phone_number = scn.nextLong();
                System.out.println("Input new record, step 2 - place SURNAME of the owner: ");
                fio = scn.next();
                System.out.println("Input new record, step 3 - place NAME of the owner: ");
                fio = fio + " " + scn.next();
                System.out.println("Input new record, step 4 - place PATRONYMIC of the owner: ");
                fio = fio + " " + scn.next();
                
                pb.put(phone_number, fio);

                System.out.println();
                System.out.println("Add new record - c, quit - q: ");
                quit = scn.next();
                }
            }
            catch (Exception e)
            {
                System.out.println("Error! Check up phone number - it contains digits only!");
            }
        System.out.println();
    }

    public static void show_records(Map<Long, String> pb) {
        for(Map.Entry<Long, String> item : pb.entrySet())
        {
            System.out.printf("Owner: %s    Phone number: %s\n", item.getValue(), item.getKey());
        }        
        System.out.println();
    }

    public static void edit_record(Map<Long, String> pb, Scanner sc) {
        System.out.println("You can edit SURNAME, NAME, PATRONYMIC.\n" +
                     "If you want to edit phone number - you should to delete old number\n" + 
                     "and ADD NEW RECORD with new phone number and old owner.");
        System.out.println("_____________________________________________________________________");             
        System.out.println("Input phone number of the record to edit: ");
        Long ph_number = sc.nextLong();
        String name = "";
        try
        {
            if (pb.containsKey(ph_number))
            {   
                System.out.println("Input SURNAME of the owner: ");
                name = sc.next();
                System.out.println("Input NAME of the owner: ");
                name = name + " " + sc.next();
                System.out.println("Input PATRONYMIC of the owner: ");
                name = name + " " + sc.next();
                
                pb.put(ph_number, name);
            }
            else
                System.out.printf("There is no such number '%s' in the phonebook", ph_number);
            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println("Error! Check up phone number - it contains digits only!");
            System.out.println();
        }
        System.out.println();
    }

    public static void remove_record(Map<Long, String> pb, Scanner sc) {
        System.out.println("Input phone number to delete: ");
        Long ph_number = sc.nextLong();
        try
            {
            if (pb.containsKey(ph_number))
                pb.remove(ph_number);        
            else
                System.out.printf("There is no such number '%s' in the phonebook", ph_number);
            System.out.println();
            }
        catch (Exception e)
            {
                System.out.println("Error! Check up phone number - it contains digits only!");
                System.out.println();
            }
        System.out.println();
    }

    public static void select_record(Map<Long, String> pb, Scanner sc) {
        Long ph_number; String name = ""; boolean flag = false;
        System.out.println("1 - select by phone number\n2 - select by name:");
        int choice = sc.nextInt();

        try
        {
            if (choice == 1)
            {
                System.out.println("Input phone number to search: ");
                ph_number = sc.nextLong();
                for(Map.Entry<Long, String> item : pb.entrySet())
                {
                    if (item.getKey().equals(ph_number))
                    {    
                        System.out.println("--------------------------------------------------------------------");
                        System.out.printf("Owner: %s    Phone number: %s\n", item.getValue(), item.getKey());
                        flag = true;
                    }
                }
                if (!flag) System.out.printf("The number %s is not found in the phonebook.", ph_number);        
                System.out.println(); flag = false;
            }
            else if (choice==2) 
            {
                System.out.println("Input SURNAME of the owner: ");
                name = sc.next();
                System.out.println("Input NAME of the owner: ");
                name = name + " " + sc.next();
                System.out.println("Input PATRONYMIC of the owner: ");
                name = name + " " + sc.next();

                for(Map.Entry<Long, String> item : pb.entrySet())
                {
                    if (item.getValue().equals(name))
                        {
                        System.out.println("--------------------------------------------------------------------");
                        System.out.printf("Owner: %s    Phone number: %s\n", item.getValue(), item.getKey());
                        flag = true;
                        }
                }        
                if (!flag) System.out.printf("Owner witn name '%s' is not found in the phonebook.", name);
                System.out.println();  flag = false;
            } 
            else 
            {
                System.out.println("Error! Incorrect choice!");    
            }
        }
        catch (Exception e)
        {
            System.out.println("Error! Check up phone number - it contains digits only!");
        }    
        System.out.println();
    }

}
