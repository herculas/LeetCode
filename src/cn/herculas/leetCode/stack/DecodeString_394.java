package cn.herculas.leetCode.stack;

import java.util.Stack;

public class DecodeString_394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ']') {

                StringBuilder interString = new StringBuilder();
                while (!stack.peek().equals("["))
                    interString.insert(0, stack.pop());

                stack.pop();

                StringBuilder repeatNum = new StringBuilder();
                while (!stack.empty() && stack.peek().length() == 1 && Character.isDigit(stack.peek().charAt(0)))
                    repeatNum.insert(0, stack.pop());
                int repeat = Integer.valueOf(repeatNum.toString());

                StringBuilder fullString = new StringBuilder();
                for (int j = 0; j < repeat; j++)
                    fullString.append(interString);
                stack.push(fullString.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.empty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String pattern = "2[abc]3[cd]ef";

        DecodeString_394 decodeString_394 = new DecodeString_394();
        System.out.println(decodeString_394.decodeString(pattern));
    }
}
