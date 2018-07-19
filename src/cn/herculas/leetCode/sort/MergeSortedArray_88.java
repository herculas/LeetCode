package cn.herculas.leetCode.sort;

public class MergeSortedArray_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int upside = m;

        int pointer1 = 0;
        int pointer2 = 0;


        while (pointer1 < upside && pointer2 < n) {
            if (nums1[pointer1] <= nums2[pointer2]) {
                pointer1++;
            } else {
                int temp = nums2[pointer2];
                this.insert(nums1, pointer1, temp);
                pointer1++;
                pointer2++;
                upside++;
            }
        }

        if (pointer1 >= upside && pointer2 < n) {
            for (int i = upside; i < nums1.length; i++, pointer2++) {
                nums1[i] = nums2[pointer2];
            }
        }
    }

    private void insert(int[] nums, int pos, int number) {
        for (int i = nums.length - 2; i >= pos; i--) {
            nums[i + 1] = nums[i];
        }
        nums[pos] = number;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 3, 6};

        MergeSortedArray_88 mergeSortedArray_88 = new MergeSortedArray_88();
        mergeSortedArray_88.merge(nums1, 3, nums2, 3);

        for (int i: nums1) {
            System.out.print(i + " ");
        }
    }
}
