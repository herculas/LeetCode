package cn.herculas.leetCode.mathematics;

public class ExcelSheetColumnNumber_171 {
    public int titleToNumber(String s) {
        int size = s.length();

        if (size == 0) {
            return 0;
        } else {
            int[] strings = new int[size];
            int sum = 0;
            for (int i = size - 1; i >= 0; i--) {
                sum += ((byte) s.charAt(i) - 64) * Math.pow(26, size - i - 1);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber_171 excelSheetColumnNumber_171 = new ExcelSheetColumnNumber_171();
        System.out.println(excelSheetColumnNumber_171.titleToNumber("AB"));
    }
}
