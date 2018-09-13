package cn.herculas.leetCode.mathematics;

public class MyPow_50 {
    private double powhelper(double x, int n) {
        if (n == 0)
            return 1;

        double res = powhelper(x, n / 2);

        if (n % 2 == 0)
            return res * res;
        else
            return res * res * x;
    }

    double myPow(double x, int n) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 1.0 / this.powhelper(x, -n);

        return this.powhelper(x, n);
    }


//    public double myPow(double x, int n) {
//        if (n > 0) {
//            double result = x;
//            if (n == 1) {
//                return x;
//            } else {
//                for (int i = 1; i < n; i++) {
//                    result *= x;
//                }
//                return result;
//            }
//
//        } else if (n == 0) {
//            return 1;
//        } else {
//            double reverse = x;
//            if (n == -1) {
//                return 1 / x;
//            } else {
//                for (int i = 1; i < -n; i++) {
//                    reverse *= x;
//                }
//                return 1 / reverse;
//            }
//        }
//    }

    public static void main(String[] args) {
        MyPow_50 myPow_50 = new MyPow_50();
        System.out.println(myPow_50.myPow(2.0000, 10));
        System.out.println(myPow_50.myPow(2.1000, 3));
        System.out.println(myPow_50.myPow(2.0000, -2));
        System.out.println(myPow_50.myPow(0.44528, 0));
    }
}
