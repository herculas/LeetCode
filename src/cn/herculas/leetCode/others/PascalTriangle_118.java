package cn.herculas.leetCode.others;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0)
            return triangle;

        List<Integer> tmp1 = new ArrayList<> ();
        tmp1.add(1);
        triangle.add(tmp1);

        for(int i = 1; i < numRows; i++) {
            List<Integer> last = triangle.get(i - 1);
            List<Integer> tmp = new ArrayList<> ();
            tmp.add(1);

            for(int j = 1; j < i; j++) {
                tmp.add(last.get(j - 1) + last.get(j));
            }
            tmp.add(1);
            triangle.add(tmp);
        }
        return triangle;
    }

    public static void main(String[] args) {
        PascalTriangle_118 pascalTriangle_118 = new PascalTriangle_118();
        System.out.println(pascalTriangle_118.generate(5));
    }
}
