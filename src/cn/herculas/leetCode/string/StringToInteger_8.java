package cn.herculas.leetCode.string;

import java.util.concurrent.ConcurrentHashMap;

public class StringToInteger_8 {
    public int myAtoi(String str) {
        str = str.trim();

        if (str.length() == 0) {
            return 0;
        }

        boolean sign = true;

        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            str = str.substring(1);
            sign = false;
        }

        if (str.length() == 0) {
            return 0;
        }

        if (!Character.isDigit(str.charAt(0))) {
            return 0;
        }

        int index = 0;
        String trueSub = str;

        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index))) {
                index++;
            } else {
                trueSub = str.substring(0, index);
                break;
            }
        }

        try {
            int noSign = Integer.parseInt(trueSub);

            if (sign) {
                return noSign;
            } else {
                return -1 * noSign;
            }
        } catch (NumberFormatException exception) {
            if (sign) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "42";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";
        String s6 = "+";
        StringToInteger_8 stringToInteger_8 = new StringToInteger_8();
        System.out.println(stringToInteger_8.myAtoi(s6));
    }
}
