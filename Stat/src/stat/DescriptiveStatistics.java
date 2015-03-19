package stat;

import java.util.ArrayList;

public class DescriptiveStatistics {
    DoubleArraySorter dAS;
    public DescriptiveStatistics() {
        dAS = new DoubleArraySorter();
    }
    public int fac(int a) {
        if(a == 0 || a == 1) {
            return 1;
        }
        int res = 1;
        for(int i = 2; i <= a; i ++) {
            res = res*i;
        }
        return res;
    }
    
    public double over(int a, int b) {
        double res = 1;
        if(b >= (a-b)) {
            for(int i = a; i > b; i --) {
                res = res*i;
            } 
            res = res/fac(a-b);
        } else {
            for(int i = a; i > (a-b); i --) {
                res = res*i;
            }
            res = res/fac(b);
        }
        return res;
    }
    
    public double sumOfSquares(ArrayList<Double> data) {
        double res = 0; 
        double mult;
        for(int i = 0; i < data.size(); i ++) {
            mult = data.get(i);
            res = res + mult*mult;
        }
        return res;
    }
    
    public double sum(ArrayList<Double> data) {
        double res = 0;
        for(int i = 0; i < data.size(); i ++) {
            res = res + data.get(i);
        }
        return res;
    }
    
    public double mean(ArrayList<Double> data) {
        double res = 0;
        return sum(data)/data.size();
    }
    
    public double geometricMean(ArrayList<Double> data) {
        double res = 1;
        int size = data.size();
        for(int i = 0; i < size; i++) {
            res = res*data.get(i);
        }
        double exp = 1/(double)size;
        res = Math.pow(res, exp);
        return res;
    }
    
    public double min(ArrayList<Double> data) { 
        data = dAS.sort(data);
        return data.get(0);
    }
    
    public double max(ArrayList<Double> data) { 
        data = dAS.sort(data);
        return data.get(data.size());
    }
    
    public double median(ArrayList<Double> data) {
        double res;
        int mid = data.size()/2;
        if((data.size() % 2) == 1) {
            res = data.get(mid);
        } else {
            res = (data.get(mid) + data.get(mid+1))/2;
        }
        return res;
    }
}
