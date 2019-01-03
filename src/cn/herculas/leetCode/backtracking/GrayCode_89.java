package cn.herculas.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {
    public List<Integer> grayCode(int n) {
        int size = (1 << n);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode_89 grayCode_89 = new GrayCode_89();
        System.out.println(grayCode_89.grayCode(3));
    }
}
