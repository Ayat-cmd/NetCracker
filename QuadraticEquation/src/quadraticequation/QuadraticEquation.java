package quadraticequation;

public class QuadraticEquation {

    private double ax2;
    private double bx;
    private double c;
    private double d;
    private double x1, x2;
    Discriminant disc;
    
    public QuadraticEquation(double ax2, double bx, double c) {
        this.ax2 = ax2;
        this.bx = bx;
        this.c = c;
    }
    
    public void Calc(){
        disc = new Discriminant();
        disc.Calculation();
    }
    
    private class Discriminant{
        void Calculation(){
            d = Math.pow(bx, 2) - 4 * ax2 * c;
            if(d > 0){
                System.out.println("Уравнение имеет два корня");
                x1 = (-bx + Math.sqrt(d))/2*ax2;
                x2 = (-bx - Math.sqrt(d))/2*ax2;
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }else if(d == 0){
                System.out.println("Уравнение имеет один корень");
                x1 = -bx/2*ax2;
                System.out.println("x = " + x1);
            }else{
                System.out.println("Уравнение не имеет корней");
            }
        }
    }
    
}
