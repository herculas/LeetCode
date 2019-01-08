package cn.herculas.leetCode.search;

import java.util.Arrays;

public class RussianDollEnvelopes_354 {
    public int maxEnvelopes(int[][] envelopes) {
        int maxL = 0;
        int[] dp = new int[envelopes.length];
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));

        for(int[] env : envelopes) {
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = lo+(hi-lo)/2;
                if(dp[mid] < env[1])
                    lo = mid+1;
                else
                    hi = mid;
            }
            dp[lo] = env[1];
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }

    public static void main(String[] args) {

    }
}
