package cn.herculas.leetCode.mathematics;

public class MySqrt_69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int lo = 1;
        int hi = x;
        int res = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid <= x / mid) {
                lo = mid + 1;
                res = mid;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MySqrt_69 mySqrt_69 = new MySqrt_69();
        System.out.println(mySqrt_69.mySqrt(16));
    }
}
