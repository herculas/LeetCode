package cn.herculas.leetCode.mathematics;

import java.util.Arrays;

public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        int[] value = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                value[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        int carry = 0;
        for (int i = value.length - 1; i >= 0; i--) {
            value[i] += carry;
            carry = value[i] / 10;
            value[i] %= 10;
        }

        int beginIndex = 0;
        while (beginIndex < value.length - 1 && value[beginIndex] == 0) {
            beginIndex++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = beginIndex; i < value.length; i++) {
            stringBuilder.append(value[i]);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String string1 = "1234";
        String string2 = "25";

        MultiplyStrings_43 multiplyStrings_43 = new MultiplyStrings_43();
        System.out.println(multiplyStrings_43.multiply(string1, string2));
    }
}
