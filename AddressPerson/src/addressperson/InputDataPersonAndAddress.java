package addressperson;

import java.util.Scanner;

public class InputDataPersonAndAddress {
    public InputDataPersonAndAddress() {
        String name = null;
        String lastName = null;
        String street = null;
        int numberHome = 0;
        int flat = 0;
        int dayBirth = 0;
        int monthBirth = 0;
        int yearBirth = 0;
        int quantityHuman = 0;

        do{
            quantityHuman = checkInt("Введите количество человек >= 4: ");
        }while(quantityHuman < 4);

        Human[] h = new Human[quantityHuman];

        for (int i = 0; i < quantityHuman; i++) {
            System.out.println((i+1)+"-й Человек");
            name = checkString("имя: ");
            lastName = checkString("фамилию: ");
            street = checkString("улицу: ");
            numberHome = checkInt("Введите номер дома: ");
            flat = checkInt("Введите номер квартиры: ");
            monthBirth = checkBirth("Введите цифру(число) месяца рождения: ", 12);
            if(monthBirth != 2) {
                dayBirth = checkBirth("Введите день рождения: ", 31);
            } else {
                dayBirth = checkBirth("Введите день рождения: ", 28);
            }
            do{
                yearBirth = checkBirth("Введите год рождеия от 1941 по 2021: ", 2021);
            }while(yearBirth < 1941);
            h[i] = new Human(name, lastName, dayBirth, monthBirth, yearBirth); 
            h[i].setStreet(street);
            h[i].setNumberHome(numberHome);
            h[i].setFlat(flat);
            System.out.println("");
        }

        while(true){
            switch(new MenuFind().Menu()){
                case 1 -> {
                    if(!findLastName(h)) {
                        System.out.println("Человека с такой фамилией нет!");
                    }
                }
                case 2 -> {
                    if(!findHumanToAddress(h)) {
                        System.out.println("Человек с таким адресом отсутствует!");
                    }
                }
                case 3 -> {
                    if(!outPeopleBornBetweenDates(h)) {
                        System.out.println("Люди родившиеся между этими датами отсутствуют!");
                    }
                }
                case 4 -> {
                    h = findOldestOrYoungest(h);
                    System.out.println("\nCамый старый:\n"+h[quantityHuman-1].humanData());
                    System.out.println("\nСамый молодой:\n"+h[0].humanData());
                    
                }
                case 5 -> {
                    if(!outputPeopleLivingSameStreet(h)) {
                        System.out.println("На такой улице проживающих нет!");
                    }
                }
                case 0 -> {
                    return;
                }
            }
        }
    }
    
    private boolean outputPeopleLivingSameStreet(Human[] h) {
        String street;
        boolean found = false;
        street = checkString("улицу: ");
        System.out.println("На улице "+street+" проживают:");
        for (Human h1 : h) {
            if(h1.findPeopleLivingSameStreet(street)) {
                System.out.println(h1.humanData()+"\n");
                found = true;
            }
        }
        return found;
    }
    
    private Human[] findOldestOrYoungest(Human[] h) {
        
        for (int i = 1; i < h.length; i++) {
            Human hTmp = h[i];
            int j = i-1;
            while(j>=0 && h[j].getYearBirth() < hTmp.getYearBirth()){
                h[j+1] = h[j];
                h[j] = hTmp;
                j--;
            }
            j = i-1;
            if(h[j].getYearBirth() == h[j+1].getYearBirth()) {
                while(j>=0 && h[j].getMonthBirth() < hTmp.getMonthBirth()) {
                    h[j+1] = h[j];
                    h[j] = hTmp;
                    j--;
                }
            }
            j = i-1;
            if(h[j].getYearBirth() == h[j+1].getYearBirth() && h[j].getMonthBirth() == h[j+1].getMonthBirth()) {
                while(j >= 0 && h[j].getDayBirth() < hTmp.getDayBirth()) {
                    h[j+1] = h[j];
                    h[j] = hTmp;
                    j--;
                }
            }
        }
        return h;
    }
    
    private boolean outPeopleBornBetweenDates(Human[] h) {
        int choice;
        int beginFindDay;
        int endFindDay;
        int beginFindMonth;
        int endFindMonth;
        int beginFindYear;
        int endFindYear;
        boolean found = false;
        do{
            System.out.println("Выберите способ вывода людей родтвшихся между определенными датами:");
            System.out.println("1 - Поиск людей родившихся между определенными днями");
            System.out.println("2 - Поиск людей родившихся между определенными месяцами");
            System.out.println("3 - Поиск людей родившихся между определеными годами");
            System.out.println("4 - Поиск людей родившихся между определенным Днем.Меяце.Годе");
            choice = checkInt("Введите выбранную цифру:");
        }while(choice > 4);
        
        switch(choice){
            case 1 -> {
                beginFindDay = beginRangeDay();
                endFindDay = endRangeDay(beginFindDay);
                
                while(beginFindDay <= endFindDay){
                    for (Human h1 : h) {
                        if(h1.findDayBirth(beginFindDay)) {
                            System.out.println(h1.humanData());
                            found = true;
                        }
                    }
                    beginFindDay++;
                }
                return found;
            }
            case 2 -> {
                beginFindMonth = beginRangeMonth();
                endFindMonth = endRangeMonth(beginFindMonth);
                
                while(beginFindMonth <= endFindMonth) {
                    for(Human h1 : h) {
                        if(h1.findMonthBirth(beginFindMonth)) {
                            System.out.println(h1.humanData());
                            found = true;
                        }
                    }
                    beginFindMonth++;
                }
                return found;
            }
            case 3 -> {
                beginFindYear = beginRangeYear();
                endFindYear = endRangeYear(beginFindYear);
                
                while(beginFindYear <= endFindYear){
                    for(Human h1 : h) {
                        if(h1.findYearBirth(beginFindYear)) {
                            System.out.println(h1.humanData());
                            found = true;
                        }
                    }
                    beginFindYear++;
                }
                return found;
            }
            default -> {
                beginFindMonth = beginRangeMonth();
                endFindMonth = endRangeMonth(beginFindMonth);
                
                beginFindDay = beginRangeDay();
                endFindDay = endRangeDay(beginFindDay);
                
                beginFindYear = beginRangeYear();
                endFindYear = endRangeYear(beginFindYear);
                
                while(beginFindYear <= endFindYear){
                    while(beginFindMonth <= endFindMonth){
                        while(beginFindDay <= endFindDay) {
                            for (Human h1 : h) {
                                if(h1.findDayBirth(beginFindDay) == true && h1.findMonthBirth(beginFindMonth) == true && h1.findYearBirth(beginFindYear) == true){
                                    System.out.println(h1.humanData());
                                    found = true;
                                }
                            }
                            beginFindDay++;
                        }
                        beginFindDay = 1;
                        beginFindMonth++;
                    }
                    beginFindMonth = 1;
                    beginFindYear++;
                }
                return found;
            }
        }
    }
    
    private int beginRangeYear() {
        System.out.println("Введите дипазон от 1941 до 2021");
                int beginFindYear;
                do{
                    beginFindYear = checkBirth("от: ", 2021);
                }while(beginFindYear < 1941);
                return beginFindYear;
    }
    
    private int endRangeYear(int beginFindYear) {
        int endFindYear;
        do{
            endFindYear = checkBirth("до: ", 2021);
        }while(endFindYear < beginFindYear);
        return endFindYear;
    }
    
    private int beginRangeMonth() {
        System.out.println("Введите дипазон от 1 до 12 месяцев");
        return checkBirth("от: ", 12);
    }
    
    private int endRangeMonth(int beginFindMonth) {
        int endFindMonth;
        do{
            endFindMonth = checkBirth("до: ", 12);
        }while(endFindMonth < beginFindMonth);
        return endFindMonth;
    }
    
    private int beginRangeDay() {
        System.out.println("Введите дипазон от 1 до 31 дня");
        return checkBirth("от: ", 31);
    }
    
    private int endRangeDay(int beginFindDay) {
        int endFindDay;
        do{
            endFindDay = checkBirth("до: ", 31);
        }while(endFindDay < beginFindDay);
        return endFindDay;
    }
    
    private boolean findHumanToAddress(Human[] h) {
        int choice;
        String findStreet;
        int findNumHume;
        int findFlat;
        boolean found = false;
        
        do{
            System.out.println("Выберите атрибут адреса, для поиска");
            System.out.println("1 - Поиск по улице");
            System.out.println("2 - Поиск по дому");
            System.out.println("3 - Поиск по квартире");
            System.out.println("4 - Поиск по улице, дому и квартире");
            choice = checkInt("Введите выбранную цифру: ");
        }while(choice > 4);
        
        switch (choice) {
            case 1 -> {
                findStreet = checkString("название улицы: ");
                for (Human h1 : h) {
                    if (h1.findStreet(findStreet)) {
                        System.out.println("\n"+h1.humanData());
                        found = true;
                    }
                }
                System.out.println();
                return found;
            }
            case 2 -> {
                findNumHume = checkInt("Введите номер дома: ");
                for (Human h1 : h) {
                    if (h1.findHome(findNumHume)) {
                        System.out.println(h1.humanData());
                        found = true;
                    }
                }
                return found;
            }
            case 3 -> {
                findFlat = checkInt("Введите номер квартиры: ");
                for (Human h1 : h) {
                    if (h1.findFlat(findFlat)) {
                        System.out.println(h1.humanData());
                        found = true;
                    }
                }
                return found;
            }
            default -> {
                findStreet = checkString("название улицы: ");
                findNumHume = checkInt("Введите номер дома: ");
                findFlat = checkInt("Введите номер квартиры: ");
                for (Human h1 : h) {
                    if(h1.findStreet(findStreet) && h1.findHome(findNumHume) && h1.findFlat(findFlat)) {
                        System.out.println(h1.humanData());
                        found = true;
                    }
                }
                return found;
            }
        }
    }
    
    private boolean findLastName(Human[] h) {
        boolean found = false;
        String findLN = checkString("фамилию: ");
        for (int i = 0; i < h.length; i++) {
            if(h[i].findLastName(findLN)) {
                System.out.println(h[i].humanData());
                found = true;
            }
        }
        return found;
    }
    
    private int checkBirth(String str, int value) {
        int check = 0;
        do{
            check = checkInt(str);
        }while(check > value);
        return check;
    }

    private String checkString(String s) {
        String str = null;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Введите "+s);
            if(!input.hasNextInt()){
                str = input.nextLine();
                flag = true;
            }else{
                input.next();
            }
        }while(!flag);
        return str;
    }

    private int checkInt(String str) {
        int value = 0;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print(str);
            if(input.hasNextInt()){
                value = input.nextInt();
                flag = true;
            }else{
                System.out.println("Некорректное значение либо нужно ввести число >0!");
                input.next();
            }
        }while(!flag || value <= 0);

        return value;
    }
}
  
