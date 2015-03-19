package stat;

public class PoissonDistribution {
    double mu;
    DescriptiveStatistics desc;
    
    public PoissonDistribution(double mu) {
        this.mu = mu;
        desc = new DescriptiveStatistics();
    }
    
    public double getExpectedValue() {
        return mu;
    }
    
    public double getStandardDeviation() {
        return Math.sqrt(mu);
    }
    
    public double getVariance() {
        return mu;
    }
    
    public double getPDF(int k) {
        return (Math.pow(mu, k)*Math.pow(Math.E, -mu))/desc.fac(k);
    }
    
    public double getCDF(int k) {
        double res = 0;
        for(int i = 0; i <= k; i ++) {
            res = res + getPDF(i);
        }
        return res;
    }
}
