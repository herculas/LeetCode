package cn.herculas.leetCode.string;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        int pointer = 0;
        int size = strs.length;

        if (size == 0) {
            return "";
        }

        if (size == 1) {
            return strs[0];
        }

        boolean iter = true;

        while (iter) {
            for (String str : strs) {
                if (str.length() == 0) {
                    return "";
                }
            }

            if (pointer == strs[0].length()) {
                break;
            }

            char temp = strs[0].charAt(pointer);

            for (int i = 1; i < size; i++) {
                if (pointer == strs[i].length()) {
                    iter = false;
                    break;
                }
                if (strs[i].charAt(pointer) != temp) {
                    iter = false;
                }
            }

            pointer++;
            if (!iter) {
                pointer--;
            }
        }

        return strs[0].substring(0, pointer);
    }

    public static void main(String[] args) {
        String[] test1 = {"flower", "flow", "flight"};
        String[] test2 = {"dog", "racecar", "car"};
        String[] test3 = {"c", "c"};

        LongestCommonPrefix_14 longestCommonPrefix_14 = new LongestCommonPrefix_14();
        System.out.println(longestCommonPrefix_14.longestCommonPrefix(test3));
    }
}
