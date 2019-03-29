import java.util.ArrayList;

public class MaszynaLosujaca {
    ArrayList<Integer> miasta;
    ArrayList<Integer> backup_miast;
    public MaszynaLosujaca(int liczba_miast){
        miasta = new ArrayList<>();
        for(int i = 1; i <= liczba_miast; i++){
            miasta.add(i);
        }
        backup_miast = new ArrayList<>(miasta);
    }
    public int losuj_miasto(){
        int i = (int) (Math.random() * miasta.size());
        return  miasta.remove(i);
    }
    public void resetuj(){
        miasta = new ArrayList<>(backup_miast);
    }

    public ArrayList<Osobnik> cross(ArrayList<Osobnik> osobniki, double px){
        ArrayList<Osobnik> ret = new ArrayList<>();
        int pop = osobniki.size();
        for(int i = 0; i < pop/2; i++){

                double los = Math.random();
                Osobnik o1 = new Osobnik(osobniki.get(i));
                Osobnik o2 = new Osobnik(osobniki.get(i * 2));
                int w= o1.tsp.length;
                //System.out.println("Przed 1: " + o1.tsp_to_string());
                //System.out.println("Przed 2: " + o2.tsp_to_string());

                if(los < px && o1.benefit != o2.benefit){

                    boolean rozpocznij = false;
                    int startn = 0;
                    int next_swap = 0;
                    int stara = 0;
                    boolean stop = false;
                    for(int k = 0; k < w && !stop; k++){

                        if(rozpocznij){
                            if(o1.tsp[k] == next_swap && stara != k){
                                //System.out.println(k + " " + o1.tsp[k] + " " + o2.tsp[k] + " n: " + next_swap + " s: " + startn);
                                o1.tsp[k] = o2.tsp[k];
                                o2.tsp[k] = next_swap;
                                next_swap = o1.tsp[k];
                                if(next_swap == startn){
                                    stop = true;
                                }
                                stara = k;
                                k = 0;
                            }
                        }
                        else if(o1.tsp[k] != o2.tsp[k]){
                            rozpocznij = true;
                            startn = o1.tsp[k];
                            next_swap = o2.tsp[k];
                            o2.tsp[k] = o1.tsp[k];
                            o1.tsp[k] = next_swap;
                            stara = k;
                        }
                    }

                    //System.out.println("Po 1: " + o1.tsp_to_string());
                    //System.out.println("Po 2: " + o2.tsp_to_string());
                }
                ret.add(o1);
                ret.add(o2);

        }
        return ret;
    }
    public ArrayList<Osobnik> mutate(ArrayList<Osobnik> osobniki, double pm){
        return osobniki;
    }
    public ArrayList<Osobnik> ruletka(ArrayList<Osobnik> osobniki){
        ArrayList<Osobnik> ret = new ArrayList<>();
        int pop = osobniki.size();
        double suma_fit = 0;
        double min_fit = osobniki.get(0).benefit;
        for(Osobnik os: osobniki){
            if(min_fit > os.benefit){
                min_fit = os.benefit;
            }
            suma_fit += os.benefit;
        }
        if(min_fit < 0){
            suma_fit -= min_fit * pop;
        }
        else
            min_fit = 0;

        for(int i = 0; i < pop; i++){
            double krecenie = Math.random() * suma_fit;
            double pol = 0;
            boolean stop = false;
            for(int j =0; j < pop && !stop; j++){
                pol += osobniki.get(j).benefit - min_fit;
                if(pol > krecenie){
                    stop = true;
                    ret.add(osobniki.get(j));
                    //System.out.println(min_fit + ", " + osobniki.get(j).benefit);
                }
            }
        }
        //System.out.println("Populacja: "+  ret.size());


        return ret;
    }
    public ArrayList<Osobnik> turniej(ArrayList<Osobnik> osobniki){
        return osobniki;
    }

}
