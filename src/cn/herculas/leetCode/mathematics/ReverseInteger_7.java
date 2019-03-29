package cn.herculas.leetCode.mathematics;

public class ReverseInteger_7 {
    public int reverse(int x) {
        boolean flag = (x >= 0);
        StringBuilder re = new StringBuilder();
        x = Math.abs(x);

        while (x != 0) {
            int temp = x % 10;
            re.append(temp);
            x /= 10;
        }
        try {
            String res = re.toString().equals("") ? "0" : re.toString();
            return flag ? Integer.parseInt(res) : -1 * Integer.parseInt(res);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        ReverseInteger_7 reverseInteger_7 = new ReverseInteger_7();
        System.out.println(reverseInteger_7.reverse(1534236469));
    }
}
