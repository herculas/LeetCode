package cn.herculas.leetCode.others;

public class NumberOf1Bits_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int c = 1;

        for(int i = 0; i < 32; i++) {
            if((n & (c << i)) != 0)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits_191 numberOf1Bits_191 = new NumberOf1Bits_191();
        System.out.println(numberOf1Bits_191.hammingWeight(11));
    }
}
