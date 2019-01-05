package cn.herculas.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }

        return this.permutationCut(numList, k);
    }

    private String permutationCut(List<Integer> numList, int k) {
        if (numList.isEmpty()) return "";

        int size = numList.size();
        int round = 1;
        for (int i = 1; i < size; i++) {
            round *= i;
        }

        int divide = k / round;
        int ref = k % round;

        if (ref == 0) {
            divide--;
            ref += round;
        }

        int thisDigit = numList.get(divide);
        numList.remove(divide);
        return String.valueOf(thisDigit) + this.permutationCut(numList, ref);

    }

    public static void main(String[] args) {
        PermutationSequence_60 permutationSequence_60 = new PermutationSequence_60();
        System.out.println(permutationSequence_60.getPermutation(4, 10));
    }
}
