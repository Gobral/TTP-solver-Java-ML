public class Osobnik {
    int[] tsp;
    int[] ksp;
    double benefit;
    public Osobnik(int[] tab){
        tsp = tab;
    }
    void ustaw_ksp(int[] ksp){
        this.ksp = ksp;
    }
    void ustaw_benefit(double b){
        benefit = b;
    }
    public Osobnik(Osobnik os){
        benefit = os.benefit;
        int tsp_l = os.tsp.length;
        int ksp_l = os.ksp.length;
        tsp = new int[tsp_l];
        ksp = new int[ksp_l];
        for(int i = 0; i < ksp_l; i++){
            ksp[i] = os.ksp[i];
        }
        for(int i = 0; i < tsp_l; i++){
            tsp[i] = os.tsp[i];
        }
    }
    public String tsp_to_string(){
        String s = "";
        for(int i: tsp){
            s += i + ", ";
        }
        return s;
    }


}
