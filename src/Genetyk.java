import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Genetyk {
    public Genetyk(Loader loader, TTP ttp, KSP ksp, int pop_size, int gen, double px, double pm, int tour){
        MaszynaLosujaca maszyna = new MaszynaLosujaca(loader.dimension);
        ArrayList<Osobnik> generacja = new ArrayList<>();
        for (int i = 0; i < pop_size; i++) {
            int tab[] = new int[loader.dimension];
            for (int j = 0; j < loader.dimension; j++) {
                tab[j] = maszyna.losuj_miasto();
                //System.out.print(tab[j] + ", ");
            }
            Osobnik os = new Osobnik(tab);
            generacja.add(os);
            //System.out.println();
            maszyna.resetuj();
        }
        double najlepszy_osobnik = 0;
        FileWriter fw;
        try {
            fw = new FileWriter("statystyka.csv");
            PrintWriter printWriter = new PrintWriter(fw);
            for(int  g = 0; g < gen; g++) {
                double srednia = 0;
                double max_local = 0;
                double min_local = najlepszy_osobnik;

                for(Osobnik os: generacja){
                    ksp.wybierz(os);
                    ttp.find_benefit(os);
                    if(najlepszy_osobnik < os.benefit){
                        najlepszy_osobnik = os.benefit;
                    }
                    srednia += os.benefit;
                    if(os.benefit > max_local){
                        max_local = os.benefit;
                    }
                    else if(os.benefit < min_local){
                        min_local = os.benefit;
                    }
                }
                srednia /= pop_size;

                printWriter.println(g + ", " + max_local + ", " + srednia + ", " +min_local);
                generacja = maszyna.ruletka(generacja);
                generacja = maszyna.cross(generacja, px);
                generacja = maszyna.mutate(generacja, pm);
            }
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
