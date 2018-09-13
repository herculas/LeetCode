package cn.herculas.leetCode.mathematics;

public class DivideTwoIntegers_29 {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long res = 0;

        if (b == 1) {
            return (int) (((dividend < 0) ^ (divisor < 0)) ? -a : a);
        }

        while (a >= b) {
            long temp = b;
            long p = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                p <<= 1;
            }
            a -= temp;
            res += p;
        }

        return (int) (((dividend < 0) ^ (divisor < 0)) ? -res : res);
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 2;

        DivideTwoIntegers_29 divideTwoIntegers_29 = new DivideTwoIntegers_29();
        System.out.println(divideTwoIntegers_29.divide(dividend, divisor));
    }
}
