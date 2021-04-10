package addressperson;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuFind {
    private Scanner input;
    private int choice;
    private boolean isNumber = false;

    public int Menu() {
        input = new Scanner(System.in);
        do{
            System.out.println("0 - Выход");
            System.out.println("1 - Поиск человека по фамилии");
            System.out.println("2 - Поиск человека по атрибуту адреса");
            System.out.println("3 - Вывести людей, родившихся между определенными датами");
            System.out.println("4 - Найти самого старого (молодого)");
            System.out.println("5 - Найти людей, проживающих на одной улице");
            System.out.print("Введите выбранную цифру: ");
            if(input.hasNextInt()) {
                choice = input.nextInt();
                isNumber = true;
            } else {
                System.out.println("Введите чило!");
                input.next();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MenuFind.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }while(choice < 0 || choice > 5);
        return choice;
    }
}
