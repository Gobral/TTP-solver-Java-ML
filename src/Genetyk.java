import java.util.ArrayList;

public class Genetyk {
    double[][] generetions;
    public Genetyk(Loader loader, TTP ttp, KSP ksp, int pop_size, int gen, double px, double pm, int tour){
        generetions = new double[gen][3];
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
            maszyna.resetuj();
        }
        double najlepszy_osobnik = 0;
        for(int  g = 0; g < gen; g++) {
            double srednia = 0;
            double max_local = -10000000;
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

            generetions[g][0] = max_local;
            generetions[g][1] = srednia;
            generetions[g][2] = min_local;

            ArrayList<Osobnik> temp = new ArrayList<>(generacja);
            generacja.clear();
            generacja = new ArrayList<>(maszyna.turniej(temp,tour));
            generacja = new ArrayList<>(maszyna.cross(generacja, px));
            maszyna.mutate(generacja, pm);

        }

    }
    double[][] get_generations(){
        return generetions;
    }
}
