package cn.herculas.leetCode.string;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            minLength = Math.min(minLength, s.length());
        }
        if (minLength == 0) return "";

        String base = strs[0];
        int cutPoint = 0;

        boolean breakFlag = false;
        for (int i = 0; i < minLength; i++) {
            for (String s : strs) {
                if (s.charAt(i) != base.charAt(i)) {
                    cutPoint = i;
                    breakFlag = true;
                    break;
                }
            }
            if (breakFlag)
                break;
        }
        if (!breakFlag) cutPoint = minLength;
        return base.substring(0, cutPoint);
    }


    public static void main(String[] args) {
        String[] test = {"c"};
        LongestCommonPrefix_14 longestCommonPrefix_14 = new LongestCommonPrefix_14();
        System.out.println(longestCommonPrefix_14.longestCommonPrefix(test));
    }
}
