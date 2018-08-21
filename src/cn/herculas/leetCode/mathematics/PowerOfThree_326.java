package cn.herculas.leetCode.mathematics;

public class PowerOfThree_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        } else {
            if (n % 3 != 0) {
                return false;
            }
            return isPowerOfThree(n / 3);
        }
    }

    public static void main(String[] args) {
        PowerOfThree_326 powerOfThree_326 = new PowerOfThree_326();

        for (int i = 0; i < 100; i++) {
            System.out.println(String.valueOf(i) + ": " + powerOfThree_326.isPowerOfThree(i));
        }
    }
}
