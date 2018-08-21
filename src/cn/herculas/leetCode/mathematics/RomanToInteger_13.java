package cn.herculas.leetCode.mathematics;

public class RomanToInteger_13 {
    public int romanToInt(String s) {
        int size = s.length();

        int sum = 0;
        int index = 0;

        while (index < size) {
            if (s.charAt(index) == 'I') {
                if (index < size - 1) {
                    if (s.charAt(index + 1) == 'V') {
                        sum += 4;
                        index += 2;
                    } else if (s.charAt(index + 1) == 'X') {
                        sum += 9;
                        index += 2;
                    } else {
                        sum += 1;
                        index += 1;
                    }
                } else {
                    sum += 1;
                    index += 1;
                }
            } else if (s.charAt(index) == 'X') {
                if (index < size - 1) {
                    if (s.charAt(index + 1) == 'L') {
                        sum += 40;
                        index += 2;
                    } else if (s.charAt(index + 1) == 'C') {
                        sum += 90;
                        index += 2;
                    } else {
                        sum += 10;
                        index += 1;
                    }
                } else {
                    sum += 10;
                    index += 1;
                }
            } else if (s.charAt(index) == 'C') {
                if (index < size - 1) {
                    if (s.charAt(index + 1) == 'D') {
                        sum += 400;
                        index += 2;
                    } else if (s.charAt(index + 1) == 'M') {
                        sum += 900;
                        index += 2;
                    } else {
                        sum += 100;
                        index += 1;
                    }
                } else {
                    sum += 100;
                    index += 1;
                }
            } else if (s.charAt(index) == 'V') {
                sum += 5;
                index += 1;
            } else if (s.charAt(index) == 'L') {
                sum += 50;
                index += 1;
            } else if (s.charAt(index) == 'D') {
                sum += 500;
                index += 1;
            } else if (s.charAt(index) == 'M') {
                sum += 1000;
                index += 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger_13 romanToInteger_13 = new RomanToInteger_13();
        System.out.println(romanToInteger_13.romanToInt("LVIII"));
    }
}
