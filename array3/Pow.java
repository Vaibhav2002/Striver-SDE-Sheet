package array3;

/**
* <a href="https://leetcode.com/problems/powx-n/">Problem</a>
**/
public class Pow {
    public double myPow(double x, int n) {
        return calcPow(x,n);
    }

    private double calcPow(double x, int n){
        double ans = 1.0;
        long pow = n;
        if(pow<0) pow*=-1;
        while(pow>0){
            if(pow%2 == 0) {
                x=x*x;
                pow/=2;
            }
            else {
                ans*=x;
                pow--;
            }
        }
        if(n<0) ans = 1.0/ans;
        return ans;
    }
}
