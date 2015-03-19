package stat;

public class HypergeometricDistribution {
    int N, n;
    double p;
    DescriptiveStatistics desc;
    
    public HypergeometricDistribution(int N, int n, double p) {
        if(p < 0 || p > 1) {
            //throw new badvalueexception or whatever
        }
        this.N = N;
        this.n = n;
        this.p = p;
        desc = new DescriptiveStatistics();
    }
    
    public double getExpectedValue() {
        return n*p;
    }
    
    public double getStandardDeviation() {
        return Math.sqrt(getVariance());
    }
    
    public double getVariance() {
        return ((N-n)/(N-1))*n*p*(1-p);
    }
    
    public double getPDF(int k) {
        return (desc.over((int)(N*p), k)*desc.over((int)(N*(1-p)), (n-k)))/desc.over(N, n);       
    }
    
    public double getCDF(int k) {
        double res = 0;
        for(int i = 0; i <= k; i ++) {
            res = res + getPDF(i);
        }
        return res;
    }
}
