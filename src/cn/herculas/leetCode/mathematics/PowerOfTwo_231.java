package cn.herculas.leetCode.mathematics;

public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;

        return this.isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        PowerOfTwo_231 powerOfTwo_231 = new PowerOfTwo_231();
        System.out.println(powerOfTwo_231.isPowerOfTwo(16));
    }
}
