package cn.herculas.leetCode.string;

public class ReverseInteger_7 {
    public int reverse(int x) {

        int result = 0;
        int newResult = 0;
        int temp;

        while(x != 0)
        {
            temp = x % 10;
            newResult = result * 10 + temp;

            if ((newResult - temp) / 10 != result)
            {
                return 0;
            }

            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        int test = 120;
        ReverseInteger_7 reverseInteger_7 = new ReverseInteger_7();

        System.out.println(reverseInteger_7.reverse(test));
    }
}
