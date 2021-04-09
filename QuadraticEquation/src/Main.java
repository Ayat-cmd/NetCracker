
import java.util.Scanner;
import quadraticequation.QuadraticEquation;

public class Main {
    
    public static double checkIn(){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        double x = 0;
        do{
            try {
                x = Double.parseDouble(sc.next());
                flag = false;
            } catch (NumberFormatException ex){
                System.out.print("Введите число: ");
                sc.reset();
            }
        }while(flag);
        return x;
    }
    
    public static void main(String[] args) {
        
        double ax2 = 0;
        double bx;
        double c;
        
        do{
            System.out.print("Введите ax2>0: ");
            ax2 = checkIn();
        }while(ax2 == 0);
        System.out.print("Введите bx: ");
        bx = checkIn();
        System.out.print("Введите c: ");
        c = checkIn();
        
        QuadraticEquation quadEq = new QuadraticEquation(ax2, bx, c);
        quadEq.Calc();
    }
}
