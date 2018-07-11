package cn.herculas.leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays_350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        int pointer1 = 0;
        int pointer2 = 0;

        int size1 = nums1.length;
        int size2 = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> arrayList = new ArrayList<>();

        while (pointer1 < size1 && pointer2 < size2) {
            if (nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                pointer2++;
            } else if (nums1[pointer1] == nums2[pointer2]) {
                arrayList.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            }
        }

        Integer[] intersec = arrayList.toArray(new Integer[arrayList.size()]);
        return Arrays.stream(intersec).mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5};
        int[] test2 = {2, 4, 6};

        IntersectionOfTwoArrays_350 intersectionOfTwoArrays_350 = new IntersectionOfTwoArrays_350();
        int[] res = intersectionOfTwoArrays_350.intersect(test1, test2);

        for (int re : res) {
            System.out.println(re);
        }
    }
}
