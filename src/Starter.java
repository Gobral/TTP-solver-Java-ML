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
        /*
        pop_size = sc.nextInt();
        gen = sc.nextInt();
        px= sc.nextDouble();
        pm = sc.nextDouble();
        tour = sc.nextInt();
        */
        sc.close();
        TTP ttp;
        Loader loader = new Loader("student\\medium_0.ttp");
        ttp = new TTP(loader.distance_matrix, loader.capacity, loader.item_values, loader.item_weights, loader.min_v, loader.max_v);
        Genetyk algorytm_genetyczny = new Genetyk(loader, ttp, pop_size, gen, px, pm, tour);

    }
}