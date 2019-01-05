package cn.herculas.leetCode.backtracking;

public class TrappingRainWater_42 {
    /**
     * 利用两个辅助数组 left 和right
     * left[i]、right[i]分别表示 i 位置左边所有数的最大值和右边所有数的最大值
     * 若 height[i] < left[i] && height[i] < right[i]，则 i 位置积水，且积水量为 min(left[i], right[i]) - height[i]
     */
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 1; i < height.length; i++)
            left[i] = Math.max(left[i - 1], height[i - 1]);
        for (int i = height.length - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], height[i + 1]);

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > left[i] || height[i] > right[i]) continue;
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater_42 trappingRainWater_42 = new TrappingRainWater_42();
        System.out.println(trappingRainWater_42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
