package stat;

public class BinomialDistribution {
    double p;
    int n;
    DescriptiveStatistics desc;
    
    public BinomialDistribution(double p, int n) {
        if(p < 0 || p > 1) {
            //throw new badvalueexception or whatever
        }
        this.p = p;
        this.n = n;
        desc = new DescriptiveStatistics();
    }
    
    public double getExpectedValue() {
        return n*p;
    }
    
    public double getStandardDeviation() {
        return Math.sqrt(n*p*(1-p));
    }
    
    public double getVariance() {
        return n*p*(1-p);
    }
    
    public double getPDF(int k) {
        return desc.over(n, k)*Math.pow(p, k)*Math.pow(1-p, n-k);
    }
    
    public double getCDF(int k) {
        double res = 0;
        for(int i = 0; i <= k; i++) {
            res = res + getPDF(i);
        }
        return res;
    }
}
