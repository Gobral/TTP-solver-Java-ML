import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Starter {
    public static void main(String args[]){

        long czasRozpoczecia = System.currentTimeMillis();

        Scanner sc= new Scanner(System.in);
        int pop_size = 100;
        int gen = 100;
        double px = 0.80;
        double pm = 0.07;
        int tour = 15;
        int ilosc_ruchomien = 20;
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

        FileWriter fw = null;
        try {
            fw = new FileWriter("statystyka_tur_15.csv");
            PrintWriter printWriter = new PrintWriter(fw);
            printWriter.println("SEP=,");
            double[] usrednione = new double[gen];
            //double[] maksymalne = new double[gen];
            //double[] minimalne = new double[gen];
            for(int g = 0; g < gen; g++){
                usrednione[g] = 0;
                //maksymalne[g] = 0;
                //minimalne[g] = 0;
            }
            for(int i = 0; i < ilosc_ruchomien; i++){
                Genetyk algorytm_genetyczny = new Genetyk(loader, ttp, ksp, pop_size, gen, px, pm, tour);
                double[][] wynik = algorytm_genetyczny.get_generations();
                for(int g = 0; g < gen; g++){
                    usrednione[g] += wynik[g][1] / ilosc_ruchomien;
                    //maksymalne[g] += wynik[g][0] / ilosc_ruchomien;
                    //minimalne[g] += wynik[g][2] / ilosc_ruchomien;
                }
            }
            //double[][] wynik = algorytm_genetyczny.get_generations();
            for(int g = 0; g < gen; g++){
                //System.out.println(g);
                //printWriter.println(g + ", " + wynik[g][0] + ", " + wynik[g][1] + ", " + wynik[g][2]);
                //printWriter.println(g + ", " + maksymalne[g] + ", "+ usrednione[g] + ", "  + minimalne[g]);
                printWriter.println(g + ", " + usrednione[g]);
            }

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long czasZakonczenia = System.currentTimeMillis();
        long czasTrwania = czasZakonczenia - czasRozpoczecia;
        System.out.println("Czas trwania: " + czasTrwania);
    }
}
