package cn.herculas.leetCode;

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int size = digits.length;

        if (size == 1 && digits[0] == 0) {
            return new int[]{1};
        }

        digits[size - 1] += 1;
        int carry = 0;

        for (int i = size - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] >= 10) {
                digits[i] -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
        }

        if (carry == 0) {
            return digits;
        } else {
            int[] res = new int[size + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, size);
            return res;
        }
    }

    public static void main(String[] args) {
        int[] test = {9, 8, 9, 9};

        PlusOne_66 plusOne_66 = new PlusOne_66();

        int[] res = plusOne_66.plusOne(test);

        for (int re : res) {
            System.out.println(re);
        }
    }
}
