package cn.herculas.leetCode.array;

import java.util.Arrays;

/**
 * Created by TantaiLan on 2017/7/6.
 */
public class RemoveElement_27 {
    public static int removeElement(int[] nums, int val) {
        int pointer = 0;

        Arrays.sort(nums);

        if (nums.length == 0)
            return 0;


        for (int i = 0; i < nums.length; ++i){
            if (nums[i] != val){
                nums[pointer] = nums[i];
                pointer ++;
            }
        }
        return pointer;
    }

    public static void main(String[] args) {
        int[] test = {3, 2, 2, 3, 4, 23, 2, 3, 4};
        int value = 23;
        int newLength = removeElement(test,value);
        System.out.println(newLength);
        for (int i = 0; i < newLength; ++ i){
            System.out.println(test[i]);
        }
    }
}
