/**Реализуйте игру в кости. Играют N игроков (компьютер в списке последний).
Подкидываются одновременно К кубиков. Выигрывает тот, у кого большая
сумма очков. Кто выиграл, тот и кидает первым в следующем кону. Игра идет
до 7 выигрышей. Начинаете игру Вы*/
package dicegames;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N;
        do{
            try {
                System.out.println("Введите чило игроков >0: (Компьтер кидает последним)");
                N = Integer.parseInt(sc.nextLine());
                if(N > 0)
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число!");
            }
        }while(true);
        
        System.out.println("Кидают все игроки одновременно!");
        System.out.println("Победитель кидает первым в следующем кону");
        DiceGames d = new DiceGames(N);
        int repeat = 0;
        do{
            if(d.getPlayerOrComp().equals("Игрок")) {
                try {
                    System.out.println("Нажмите любую цивру чтобы бросить кубик");
                    N = Integer.parseInt(sc.nextLine());
                    d.repeatSeven();
                    System.out.println((repeat+1)+" выйгришь!");
                    repeat++;
                } catch (NumberFormatException e) {
                    System.out.println("Введено не целое число!");
                }
            }else{
                d.repeatSeven();
                System.out.println((repeat+1)+" выйгришь!");
                repeat++;
            }
        }while(repeat < 7);
    }
}
