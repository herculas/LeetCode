package cn.herculas.leetCode.string;

import java.util.Stack;

public class BasicCalculator_227 {
    public int calculate(String s) {
        int md = -1; // m(0) means multiple, d(1) means divide
        int sign = 1; // -1 means minus, 1 means plus

        int prev = 0;
        int result = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                int num = c - '0';
                while(++i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                }
                i--; // back to last digit of number

                if(md == 0){
                    prev = prev * num;
                    md = -1;
                }else if(md == 1){
                    prev = prev / num;
                    md = -1;
                }else{
                    prev = num;
                }
            } else if(c == '/') {
                md = 1;
            } else if(c == '*') {
                md = 0;
            } else if(c == '+') {
                result = result + sign * prev;
                sign = 1;
            } else if(c == '-') {
                result = result + sign * prev;
                sign = -1;
            }
        }

        result = result + sign * prev;
        return result;
    }

    public static void main(String[] args) {
        String s1 = "3+2*2";
        String s2 = " 3/2 ";
        String s3 = " 3+5 / 2 ";

        BasicCalculator_227 basicCalculator_227 = new BasicCalculator_227();
        System.out.println(basicCalculator_227.calculate(s3));

    }
}
