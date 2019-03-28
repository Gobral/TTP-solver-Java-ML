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

        return osobniki;
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
                    System.out.println(min_fit + ", " + osobniki.get(j).benefit);
                }
            }
        }
        System.out.println("Populacja: "+  ret.size());


        return ret;
    }
    public ArrayList<Osobnik> turniej(ArrayList<Osobnik> osobniki){
        return osobniki;
    }

}
