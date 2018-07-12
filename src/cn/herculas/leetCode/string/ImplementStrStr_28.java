package cn.herculas.leetCode.string;

public class ImplementStrStr_28 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack1 = "hello";
        String needle1 = "ll";

        String haystack2 = "aaaaa";
        String needle2 = "bba";

        ImplementStrStr_28 implementStrStr_28 = new ImplementStrStr_28();

        System.out.println(implementStrStr_28.strStr(haystack2, needle2));
    }
}
