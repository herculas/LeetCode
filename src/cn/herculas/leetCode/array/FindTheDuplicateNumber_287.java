package cn.herculas.leetCode.array;

public class FindTheDuplicateNumber_287 {

    public int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (nums[slow] != nums[fast]);

        int restart = 0;

        while (nums[restart] != nums[slow]) {
            restart = nums[restart];
            slow = nums[slow];
        }

        return nums[restart];
    }


    public static void main(String[] args) {
        int[] test = {1, 3, 4, 2, 2};
        FindTheDuplicateNumber_287 findTheDuplicateNumber_287 = new FindTheDuplicateNumber_287();
        System.out.println(findTheDuplicateNumber_287.findDuplicate(test));

    }
}
