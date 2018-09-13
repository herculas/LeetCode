package cn.herculas.leetCode.mathematics;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
    public boolean isHappy(int n) {
        Set<Integer> integerSet = new HashSet<>();
        return define(n, integerSet);
    }

    private boolean define(int n, Set<Integer> integerSet) {
        if (n == 1) {
            return true;
        } else {
            int index = n;
            int iter;
            int sum = 0;
            while (index != 0) {
                iter = index % 10;
                sum += iter * iter;
                index /= 10;
            }
            if (integerSet.contains(sum)) {
                return false;
            } else {
                integerSet.add(sum);
                return this.define(sum, integerSet);
            }
        }
    }

    public static void main(String[] args) {
        int n = 20;
        HappyNumber_202 happyNumber_202 = new HappyNumber_202();
        System.out.println(happyNumber_202.isHappy(n));
    }
}
