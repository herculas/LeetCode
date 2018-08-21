package cn.herculas.leetCode.mathematics;

public class CountPrimes_204 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];

        for (int i = 0; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if(!isPrime[i])
                continue;
            for (int j = 2; j * i < n; j++) {
                isPrime[i * j] = false;
            }
        }

        int res = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime[i])
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int test = 100;
        CountPrimes_204 countPrimes_204 = new CountPrimes_204();
        System.out.println(countPrimes_204.countPrimes(test));
    }
}
