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
        for(int  g = 0; g < gen; g++) {

            for(Osobnik os: generacja){
                ksp.wybierz(os);
                ttp.find_benefit(os);
            }
            generacja = maszyna.ruletka(generacja);
            generacja = maszyna.cross(generacja, px);
            generacja = maszyna.mutate(generacja, pm);
        }

    }
}
