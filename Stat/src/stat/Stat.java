package stat;

import java.util.ArrayList;

public class Stat {
    public static void main(String[] args) {
        new Stat();
    }
    public Stat() {
        DescriptiveStatistics desc = new DescriptiveStatistics();
        DoubleArraySorter dAS = new DoubleArraySorter();
        NormalDistribution norm = new NormalDistribution(0, 1);
        BinomialDistribution bin = new BinomialDistribution(0.3, 12);
        PoissonDistribution poi = new PoissonDistribution(0.5);
        HypergeometricDistribution hyp = new HypergeometricDistribution(12, 4, 0.5);
        ArrayList<Double> test = new ArrayList<Double>();
        test.add(1.0);
        test.add(2.0);
        test.add(3.0);
        test.add(4.0);
        System.out.println(hyp.getPDF(1));
    }
    
}