package cn.herculas.leetCode;

/**
 * Created by wurah on 2017/7/5.
 */
public class RemoveDuplicates_26 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int pointer = 0;

        for (int i = 0; i < nums.length; ++i){
            if(nums[i] != nums[pointer])
                nums[++pointer] = nums[i];
        }
        return ++pointer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 4, 5};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }
}
