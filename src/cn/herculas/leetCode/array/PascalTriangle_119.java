package cn.herculas.leetCode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_119 {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> last;
        List<Integer> res = new ArrayList<>();

        if (rowIndex == 0)
            return res;

        res.add(1);
        if (rowIndex == 1)
            return res;

        for (int i = 1; i < rowIndex; i++) {
            last = res;
            res = new ArrayList<>();

            res.add(1);
            for (int j = 1; j < i; j++) {
                res.add(last.get(j - 1) + last.get(j));
            }
            res.add(1);
        }
        return res;
    }

    public static void main(String[] args) {
        PascalTriangle_119 pascalTriangle_119 = new PascalTriangle_119();
        System.out.println(pascalTriangle_119.getRow(3));
    }
}
