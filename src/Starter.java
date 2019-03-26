import java.util.ArrayList;
import java.util.Scanner;

public class Starter {
    public static void main(String args[]){

        Scanner sc= new Scanner(System.in);
        int pop_size = 100;
        int gen = 100;
        double px= 0.7;
        double pm = 0.1;
        int tour = 5;
      //  pop_size = sc.nextInt();
      //  gen = sc.nextInt();
      //  px= sc.nextDouble();
      //  pm = sc.nextDouble();
      //  tour = sc.nextInt();
        sc.close();
        Genetyk algorytm_genetyczny = new Genetyk(pop_size, gen, px, pm, tour);

    }
}
