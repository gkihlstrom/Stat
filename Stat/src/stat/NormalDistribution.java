package stat;

public class NormalDistribution {
    double mu, sigma;
    NormalDistribution standardND;
    
    public NormalDistribution(double mu, double sigma) {
        this.mu = mu;
        this.sigma = sigma;
    }
    
    public double getExpectedValue() {
        return mu;
    }
    
    public double getStandardDeviation() {
        return sigma;
    }
    
    public double getVariance() {
        return Math.pow(sigma, 2);
    }
    
    public double getPDF(double X) {
        double res;
        if(X < 0) {
            X = -1*X;
            res = 1 - (1/(sigma*Math.sqrt(2*Math.PI)))*Math.pow(Math.E, -1*Math.pow((X - mu),2)/(2*Math.pow(sigma,2)));
        } else {
            res = (1/(sigma*Math.sqrt(2*Math.PI)))*Math.pow(Math.E, -1*Math.pow((X - mu),2)/(2*Math.pow(sigma,2)));
    }
        return res;
    }
    
    public double getCDF(double X) {
        double res;
        if(X >= 0) {
            res = trapezoidalApprox(X);
        } else {
            X = -1*X;
            res = 1 - trapezoidalApprox(X);
        }
        return res;
    }
    
    private double trapezoidalApprox(double X) {
        standardND = new NormalDistribution(0,1);
        double T = 0; 
        int n = 100;
        double h = X/n;
        for(int i = 1; i < n; i++) {
            T = T + standardND.getPDF((i-mu)/sigma);
        }
        T = T + (standardND.getPDF((0-mu)/sigma) + standardND.getPDF((X-mu)/sigma))/2;
        T = T*h;
        T = T + 0.5;
        return T;
    }
}