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

}
