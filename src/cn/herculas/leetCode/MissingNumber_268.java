package cn.herculas.leetCode;

/**
 * Created by wurah on 2017/7/4.
 */
public class MissingNumber_268 {
    public static int missingNumber(int[] nums){
        int xor = 0;
        int i = 0;

        for(i=0; i<nums.length;++i){
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }

    public static void main(String[] args) {
        int[] test ={0, 1, 2, 3, 4};
        int miss = missingNumber(test);
        System.out.println(miss);
    }
}
