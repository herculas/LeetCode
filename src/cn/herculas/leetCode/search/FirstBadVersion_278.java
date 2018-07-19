package cn.herculas.leetCode.search;

public class FirstBadVersion_278 {
    private boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int middle;

        while (left < right) {
            middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int n = 2126753390;

        FirstBadVersion_278 firstBadVersion_278 = new FirstBadVersion_278();
        System.out.println(firstBadVersion_278.firstBadVersion(n));
    }
}
