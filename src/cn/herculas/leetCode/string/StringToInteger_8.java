package cn.herculas.leetCode.string;

public class StringToInteger_8 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        int flag = 1;
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            flag = -1;
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }

        int i;
        for (i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                break;
        }

        str = str.substring(0, i);
        if (str.length() == 0) return 0;

        int result = 0;
        for (int j = 0; j < str.length(); j++) {
            boolean overflow = false;
            long r = (long)result;

            result *= 10;
            long newR = r * (long)10;
            if ((int) newR != newR) overflow = true;

            int newNewR = result;
            result += str.charAt(j) - '0';

            if (((newNewR ^ result) & ((str.charAt(j) - '0') ^ result)) < 0) {
                overflow = true;
            }

            if (overflow) {
                if (flag == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
        }

        return result * flag;
    }

    public static void main(String[] args) {
        String s1 = "42";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-6147483648";
        String s6 = "+";

        StringToInteger_8 stringToInteger_8 = new StringToInteger_8();

        System.out.println(stringToInteger_8.myAtoi(s1));
        System.out.println(stringToInteger_8.myAtoi(s2));
        System.out.println(stringToInteger_8.myAtoi(s3));
        System.out.println(stringToInteger_8.myAtoi(s4));
        System.out.println(stringToInteger_8.myAtoi(s5));
        System.out.println(stringToInteger_8.myAtoi(s6));
    }
}
