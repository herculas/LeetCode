package cn.herculas.leetCode.dp;

public class NimGame_292 {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        NimGame_292 nimGame_292 = new NimGame_292();
        System.out.println(nimGame_292.canWinNim(1348820612));
    }
}
