package cn.herculas.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return result;
        }
        this.addParenthesis(n, n, "");
        return result;
    }

    private void addParenthesis(int left, int right, String string) {
        if (right == 0) {
            result.add(string);
        } else {
            if (left > 0) {
                this.addParenthesis(left - 1, right, string + "(");
            }
            if (right > left) {
                this.addParenthesis(left, right - 1, string + ")");
            }
        }
    }

    public static void main(String[] args) {
        GenerateParentheses_22 generateParentheses_22 = new GenerateParentheses_22();
        System.out.println(generateParentheses_22.generateParenthesis(3));
    }
}
