package cn.herculas.leetCode.mathematics;

public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int nums = 0;
        int temp = x;
        int left, right;
        while (temp != 0) {
            temp /= 10;
            nums++;
        }
        left = nums - 1;
        right = 0;
        while (left > right) {
            if (getDigit(x, left--) != getDigit(x, right++))
                return false;
        }
        return true;
    }

    private int getDigit(int x, int i) {
        x = x / (int)Math.pow(10, i);
        return x % 10;
    }

    public static void main(String[] args) {
        PalindromeNumber_9 palindromeNumber_9 = new PalindromeNumber_9();
        System.out.println(palindromeNumber_9.isPalindrome(1000021));
    }
}
