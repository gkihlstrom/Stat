package stat;

import java.util.ArrayList;

public class DoubleArraySorter {
    public DoubleArraySorter() {
        
    }
    public ArrayList<Double> sort(ArrayList<Double> data) {
        for(int i = 0; i < data.size(); i ++) {
            double x = data.get(i);
            int j = i;
            while(j > 0 && data.get(j-1) > x) {
                data.set(j, data.get(j-1));
                j = j - 1;
            }
            data.set(j, x);
        }
        return data;
    }
}
