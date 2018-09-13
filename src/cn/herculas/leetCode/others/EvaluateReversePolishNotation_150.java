package cn.herculas.leetCode.others;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if ( (Character.isDigit(tokens[i].charAt(0)))
                    || (tokens[i].length() != 1 && tokens[i].charAt(0) == '-' && Character.isDigit(tokens[i].charAt(1)))
            ) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                if (tokens[i].charAt(0) == '+') {
                    stack.push(a + b);
                } else if (tokens[i].charAt(0) == '-') {
                    stack.push(a - b);
                } else if (tokens[i].charAt(0) == '*') {
                    stack.push(a * b);
                } else if (tokens[i].charAt(0) == '/') {
                    stack.push(a / b);
                } else {
                    throw new RuntimeException();
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] strings = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        EvaluateReversePolishNotation_150 evaluateReversePolishNotation_150 = new EvaluateReversePolishNotation_150();
        System.out.println(evaluateReversePolishNotation_150.evalRPN(strings));
    }
}
