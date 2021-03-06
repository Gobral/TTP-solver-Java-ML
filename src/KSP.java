import java.util.ArrayList;

public class KSP {
    double backpack_cap;
    double[] weights;
    int[] values;
    int number_of_items;
    double items_rate[];
    public KSP(double backpack_cap, double[] weights, int[] values, int[] asssigned_town, int noi){
        this.backpack_cap = backpack_cap;
        this.weights = weights;
        this.values = values;
        number_of_items = noi;
        items_rate = new double[number_of_items];
        for(int i = 0; i < number_of_items; i++) {
            items_rate[i] = values[i] / weights[i];
        }
    }
    void wybierz(Osobnik os){
        int ksp[] = new int[number_of_items];
        ArrayList<Integer> sort = new ArrayList<>();
        for(int i = 0; i < number_of_items; i++){
            //System.out.println(items_rate[i]);
            ksp[i] = 0;
            int paste_index = i;
            boolean stop = false;
            for(int j = 0; j < i && !stop; j++){
                if(items_rate[sort.get(j)] < items_rate[i]){
                    paste_index = j;
                    stop = true;
                }
            }
            sort.add(paste_index, i);
        }
        double akt_backpack = backpack_cap;
        int i = 0;
        while(akt_backpack > 0 && i < number_of_items){
            double w_temp = weights[sort.get(i)];
            if(akt_backpack - w_temp >= 0){
                akt_backpack -= w_temp;
                ksp[sort.get(i)] = 1;
            }
            //System.out.println(akt_backpack);
            i++;
        }
        os.ustaw_ksp(ksp);
    }
}
