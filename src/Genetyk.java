import java.util.ArrayList;
import java.util.Scanner;

public class Genetyk {
    public Genetyk(Loader loader, TTP ttp, int pop_size, int gen, double px, double pm, int tour){
        System.out.println("Siema siema");
        MaszynaLosujaca maszyna = new MaszynaLosujaca(loader.dimension);
        ArrayList<Osobnik> generacja = new ArrayList<>();
        KSP ksp = new KSP(loader.capacity, loader.item_weights, loader.item_values, loader.number_of_items);
        for(int i = 0; i < pop_size; i++){
            int tab[] = new int[loader.dimension];
            for(int j = 0; j < loader.dimension; j++){
                tab[j] = maszyna.losuj_miasto();
                //System.out.print(tab[j] + ", ");
            }
            Osobnik os = new Osobnik(tab);
            ksp.wybierz(os);
            generacja.add(os);
            //System.out.println();
            maszyna.resetuj();
        }



    }
}
