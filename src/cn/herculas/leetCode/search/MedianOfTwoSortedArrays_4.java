package cn.herculas.leetCode.search;

public class MedianOfTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int lenSum = len1 + len2;

        int mid1;
        int mid2;

        if (lenSum % 2 == 0) {
            mid1 = lenSum / 2;
            mid2 = lenSum / 2 + 1;
        } else {
            mid1 = mid2 = lenSum / 2 + 1;
        }

        int pointer = 0;
        int pointer1 = 0;
        int pointer2 = 0;

        int mid1Num = 0;
        int mid2Num = 0;

        while (pointer < mid2) {
            int a = (pointer1 < len1) ? nums1[pointer1] : Integer.MAX_VALUE;
            int b = (pointer2 < len2) ? nums2[pointer2] : Integer.MAX_VALUE;

            if (a < b) {
                pointer++;
                pointer1++;
            } else {
                pointer++;
                pointer2++;
            }

            if (pointer == mid1) mid1Num = Math.min(a, b);
            if (pointer == mid2) mid2Num = Math.min(a, b);
        }
        return (mid1Num + mid2Num) / 2.0;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 4};
        int[] num2 = {1, 4, 5, 8};

        MedianOfTwoSortedArrays_4 medianOfTwoSortedArrays_4 = new MedianOfTwoSortedArrays_4();
        System.out.println(medianOfTwoSortedArrays_4.findMedianSortedArrays(num1, num2));
    }
}
