package cn.herculas.leetCode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf_315 {

    public List<Integer> countSmaller(int[] nums) {

        List<Integer> arrayInOrder = new ArrayList<>();
        Integer[] resultArray = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0;
            int right = arrayInOrder.size();

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arrayInOrder.get(mid) >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            resultArray[i] = left;
            arrayInOrder.add(left, nums[i]);
        }

        return Arrays.asList(resultArray);
    }

    public static void main(String[] args) {
        int[] test = {5, 2, 6, 1};

        CountOfSmallerNumbersAfterSelf_315 countOfSmallerNumbersAfterSelf_315 = new CountOfSmallerNumbersAfterSelf_315();
        List<Integer> res = countOfSmallerNumbersAfterSelf_315.countSmaller(test);

        System.out.println(Arrays.deepToString(new List[]{res}));
    }
}
