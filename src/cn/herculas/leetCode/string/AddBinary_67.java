package cn.herculas.leetCode.string;

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        int maxLen = Math.max(aLen, bLen);

        char[] res = new char[maxLen + 1];

        int carry = 0;
        for (int i = maxLen - 1; i >= 0; i--) {

        }
        return "yes";
    }

    public static void main(String[] args) {
        String a1 = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b1 = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        String a2 = "1010";
        String b2 = "1011";

        System.out.println("1010".length());

        AddBinary_67 addBinary_67 = new AddBinary_67();
        System.out.println(addBinary_67.addBinary(a1, b1));
        System.out.println(addBinary_67.addBinary(a2, b2));
    }
}
