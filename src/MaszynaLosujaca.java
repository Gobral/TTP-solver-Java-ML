import java.util.ArrayList;

public class MaszynaLosujaca {
    ArrayList<Integer> miasta;
    ArrayList<Integer> backup_miast;
    public MaszynaLosujaca(int liczba_miast){
        miasta = new ArrayList<>();
        for(int i = 0; i < liczba_miast; i++){
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
}
