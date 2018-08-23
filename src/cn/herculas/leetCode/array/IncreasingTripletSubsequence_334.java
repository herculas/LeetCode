package cn.herculas.leetCode.array;

public class IncreasingTripletSubsequence_334 {
    public boolean increasingTriplet(int[] nums) {
        int minimal = Integer.MAX_VALUE;
        int medium = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= minimal) {
                minimal = n;
            } else if (n <= medium) {
                medium = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence_334 increasingTripletSubsequence_334 = new IncreasingTripletSubsequence_334();
        int[] test1 = {5, 3, 2, 4, 1, 6};
        int[] test2 = {5, 3, 2, 4, 1};

        System.out.println(increasingTripletSubsequence_334.increasingTriplet(test1));
        System.out.println(increasingTripletSubsequence_334.increasingTriplet(test2));
    }
}
