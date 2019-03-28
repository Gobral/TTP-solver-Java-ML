public class TTP {
    double[][] distance_matrix;
    double backpack_capitacity;
    int[] item_values;
    double[] item_weights;

    double v_min;
    double v_max;

    public TTP(double[][] distance_matrix,  double backpack_capitacity, int[] item_values, double[] item_weights, double v_min, double v_max){
        this.distance_matrix = distance_matrix;
        this.backpack_capitacity = backpack_capitacity;
        this.item_values = item_values;
        this.item_weights = item_weights;
        this.v_min = v_min;
        this.v_max = v_max;
    }
    double find_benefit(int[] x, int[] z){
        double benefit = -1000;
        double weight_current = 0;
        double value_current = 0;
        double total_time = 0;
        for(int i = 0; i < x.length - 1; i++){
            for(int k = 0; k < z.length - 1; k++){
                if(z[k] == x[i]){
                    weight_current += item_weights[k];
                    value_current += item_values[k];
                }
            }
            total_time += calculate_time(distance_matrix[x[i] - 1][x[i+1] - 1], weight_current);
        }
        total_time += calculate_time(distance_matrix[x[x.length - 1] - 1][x[0] - 1] , weight_current);
        benefit = value_current - total_time;
        //System.out.println("total benefit: " + benefit);

        return benefit;
    }
    void find_benefit(Osobnik os){
        os.ustaw_benefit( find_benefit(os.tsp, os.ksp));
    }
    void find_pov_benefit(Osobnik os){
        os.ustaw_benefit( Math.pow(Math.E, find_benefit(os.tsp, os.ksp)));
    }
    double calculate_time(double distance, double w_c){
        double v = v_max - ((v_max - v_min) * w_c / backpack_capitacity);
        return distance / v;
    }
}
