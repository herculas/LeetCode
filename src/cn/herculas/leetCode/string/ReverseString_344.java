package cn.herculas.leetCode.string;

public class ReverseString_344 {
    public String reverseString(String s) {
        int size = s.length();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = size - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String test = "hello!";
        ReverseString_344 reverseString_344 = new ReverseString_344();
        System.out.println(reverseString_344.reverseString(test));
    }
}
