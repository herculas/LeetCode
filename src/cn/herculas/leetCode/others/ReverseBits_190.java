package cn.herculas.leetCode.others;

import java.math.BigInteger;

public class ReverseBits_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i ++) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseBits_190 reverseBits_190 = new ReverseBits_190();

        System.out.println(Integer.MAX_VALUE);

        System.out.println(reverseBits_190.reverseBits(43261596));
    }
}
