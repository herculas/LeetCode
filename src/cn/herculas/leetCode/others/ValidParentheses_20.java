package cn.herculas.leetCode.others;

import java.util.Stack;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int size = s.length();

        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (!stack.empty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses_20 validParentheses_20 = new ValidParentheses_20();
        System.out.println(validParentheses_20.isValid("()[]{}"));
        System.out.println(validParentheses_20.isValid("(]"));
        System.out.println(validParentheses_20.isValid("([)]"));
        System.out.println(validParentheses_20.isValid("{[]}"));
    }
}
