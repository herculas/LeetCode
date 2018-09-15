package cn.herculas.leetCode.array;

import java.util.HashMap;
import java.util.Map;

public class FourSum_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> sumMap = new HashMap<>();
        int result = 0;

        for (int a : A) {
            for (int b : B) {
                if (sumMap.containsKey(a + b)) {
                    sumMap.put(a + b, sumMap.get(a + b) + 1);
                } else {
                    sumMap.put(a + b, 1);
                }
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                if (sumMap.containsKey(-sum)) {
                    result += sumMap.get(-sum);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        FourSum_454 fourSum_454 = new FourSum_454();
        System.out.println(fourSum_454.fourSumCount(A, B, C, D));
    }
 }
