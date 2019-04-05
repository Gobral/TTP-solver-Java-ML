import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Starter {
    public static void main(String args[]){

        Scanner sc= new Scanner(System.in);
        int pop_size = 100;
        int gen = 150;
        double px= 0.7;
        double pm = 0.01 ;
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
        KSP ksp = new KSP(loader.capacity, loader.item_weights, loader.item_values,loader.assigned_node, loader.number_of_items);
        Genetyk algorytm_genetyczny = new Genetyk(loader, ttp, ksp, pop_size, gen, px, pm, tour);

        FileWriter fw = null;
        try {
            fw = new FileWriter("statystyka.csv");
            PrintWriter printWriter = new PrintWriter(fw);
            printWriter.println("SEP=,");
            double[][] wynik = algorytm_genetyczny.get_generations();
            for(int g = 0; g < gen; g++){
                //System.out.println(g);
                printWriter.println(g + ", " + wynik[g][0] + ", " + wynik[g][1] + ", " + wynik[g][2]);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
