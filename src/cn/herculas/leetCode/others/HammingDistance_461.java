package cn.herculas.leetCode.others;

public class HammingDistance_461 {
    public int hammingDistance(int x, int y) {
        int distance = 0;
        int index = 1;

        for(int i = 0; i < 32; i++) {
            if((x & (index << i)) != (y & (index << i)))
                distance++;
        }

        return distance;
    }

    public static void main(String[] args) {
        HammingDistance_461 hammingDistance_461 = new HammingDistance_461();
        System.out.println(hammingDistance_461.hammingDistance(1, 4));
    }
}
