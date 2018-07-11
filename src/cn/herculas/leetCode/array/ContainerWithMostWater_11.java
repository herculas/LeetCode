package cn.herculas.leetCode.array;

/**
 * Created by wurah on 2017/7/4.
 */
public class ContainerWithMostWater_11 {
    public static int maxArea(int[] height){

        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while(left < right){
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left ++;
            }
            else {
                right --;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,3,3,4,6};
        int maxAA = maxArea(height);
        System.out.println(maxAA);
    }
}
