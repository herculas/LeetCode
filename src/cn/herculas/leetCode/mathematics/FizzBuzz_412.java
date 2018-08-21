package cn.herculas.leetCode.mathematics;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                list.add(String.valueOf(i));
            } else if (i % 3 == 0 && i % 5 != 0) {
                list.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                list.add("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int test = 15;

        FizzBuzz_412 fizzBuzz_412 = new FizzBuzz_412();
        List<String> list = fizzBuzz_412.fizzBuzz(test);
        System.out.println(list);
    }
}
