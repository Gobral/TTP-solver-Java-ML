import java.util.Scanner;

public class Genetyk {
    public Genetyk(int pop_size, int gen, double px, double pm, int tour){
        System.out.println("Siema siema");
        TTP ttp;
        Loader loader = new Loader("student\\medium_0.ttp");
        ttp = new TTP(loader.distance_matrix, loader.capacity, loader.item_values, loader.item_weights, loader.min_v, loader.max_v);
        MaszynaLosujaca maszyna = new MaszynaLosujaca(loader.dimension);

    }
}
