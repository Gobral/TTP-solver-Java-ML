import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Loader {
    int dimension;
    int number_of_items;
    int capacity;
    double min_v;
    double max_v;
    int[] item_values;
    double[] item_weights;
    int[] assigned_node;
    double[][] distance_matrix;
    public Loader(String fileName){
        File file = new File(fileName);
        Scanner sc  = null;
        try {
            sc = new Scanner(file);
            sc.useLocale(Locale.US);
            System.out.println(sc.nextLine());
            sc.nextLine();
            sc.next();
            dimension = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i < 3; ++i){
                sc.next();
            }
            number_of_items = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i < 3; ++i){
                sc.next();
            }
            capacity = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i < 2; ++i){
                sc.next();
            }
            min_v = sc.nextDouble();
            sc.nextLine();
            for(int i = 0; i < 2; ++i){
                sc.next();
            }
            max_v = sc.nextDouble();
            for(int i = 0; i < 4; ++i){
                sc.nextLine();
            }
            double[][] temp_distances = new double[dimension][2];
            distance_matrix = new double[dimension][dimension];
            for(int i = 0 ; i < dimension; i++){
                sc.next();
                temp_distances[i][0] = sc.nextDouble();
                temp_distances[i][1] = sc.nextDouble();
                sc.nextLine();
                //System.out.println(temp_distances[i][0] + " " + temp_distances[i][1]);
            }
            sc.nextLine();
            item_values = new int[number_of_items];
            item_weights = new double[number_of_items];
            assigned_node = new int[number_of_items];
            for(int i = 0; i < number_of_items; i++){
                sc.next();
                item_values[i] = sc.nextInt();
                item_weights[i] = sc.nextDouble();
                assigned_node[i] = sc.nextInt();
                sc.nextLine();
            }
            sc.close();
            for(int i = 0; i < dimension; i++){
                for(int j = 0; j < dimension; j++){
                    distance_matrix[i][j] = get_distance(temp_distances[i][0], temp_distances[i][1], temp_distances[j][0], temp_distances[j][1]);
                    //System.out.println(distance_matrix[i][j]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    double get_distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1 - x2,2) + Math.pow(y1 - y2,2));
    }
}
