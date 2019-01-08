package cn.herculas.leetCode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) return 0;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstLevel = new ArrayList<>();
        firstLevel.add(triangle.get(0).get(0));
        result.add(firstLevel);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> lastLevelRes = result.get(i - 1);
            List<Integer> thisLevelTri = triangle.get(i);

            List<Integer> thisLevelRes = new ArrayList<>();
            for (int j = 0; j < thisLevelTri.size(); j++) {
                if (j == 0){
                    thisLevelRes.add(j, lastLevelRes.get(j) + thisLevelTri.get(j));
                } else if (j == thisLevelTri.size() - 1) {
                    thisLevelRes.add(j, lastLevelRes.get(j - 1) + thisLevelTri.get(j));
                } else {
                    thisLevelRes.add(j, Math.min(lastLevelRes.get(j - 1), lastLevelRes.get(j)) + thisLevelTri.get(j));
                }
            }
            result.add(thisLevelRes);
        }

        List<Integer> last = result.get(result.size() - 1);
        int mini = Integer.MAX_VALUE;
        for (int i : last) {
            mini = Math.min(mini, i);
        }

        return mini;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3, 4);
        List<Integer> l3 = Arrays.asList(6, 5, 7);
        List<Integer> l4 = Arrays.asList(4, 1, 8, 3);

        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);

        Triangle_120 triangle_120 = new Triangle_120();
        System.out.println(triangle_120.minimumTotal(triangle));
    }
}
