package cn.herculas.leetCode.dp;

public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int reach=0;
        int i=0;

        while(i<nums.length && i<=reach) {

            reach=Math.max(reach,i+nums[i]);
            i++;
        }

        return reach>=nums.length-1;
    }

//    public boolean canJump(int[] nums) {
//        if (nums.length == 0) {
//            return false;
//        }
//        return this.canJump(nums, 0);
//    }
//
//    private boolean canJump(int[] nums, int index) {
//        if (nums.length != 1 && nums[index] == 0) {
//            return false;
//        }
//
//        if (index == nums.length - 1) {
//            return true;
//        }
//
//        if (index + nums[index] >= nums.length - 1) {
//            return true;
//        }
//
//        for (int i = 1; i <= nums[index]; i++) {
//            if (this.canJump(nums, index + i)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        int[] test = {3, 2, 1, 0, 4};

        JumpGame_55 jumpGame_55 = new JumpGame_55();
        System.out.println(jumpGame_55.canJump(test));
    }
}
