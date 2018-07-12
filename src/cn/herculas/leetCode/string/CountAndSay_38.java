package cn.herculas.leetCode.string;

public class CountAndSay_38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String string = this.countAndSay(n - 1) + "*";
        char[] chars = string.toCharArray();

        int count = 1;

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                output.append(count).append(chars[i]);
                count = 1;
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        int test = 9;

        CountAndSay_38 countAndSay_38 = new CountAndSay_38();
        System.out.println(countAndSay_38.countAndSay(test));
    }
}
