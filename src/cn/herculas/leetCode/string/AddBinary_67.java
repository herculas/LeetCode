package cn.herculas.leetCode.string;

public class AddBinary_67 {
    public String addBinary(String a, String b) {

        StringBuilder stringBuilder = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;

        while (aIndex >= 0 || bIndex >= 0) {
            int sum = carry;
            if (aIndex >= 0)
                sum += a.charAt(aIndex--) - '0';
            if (bIndex >= 0)
                sum += b.charAt(bIndex--) - '0';

            stringBuilder.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0)
            stringBuilder.append(carry);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String a1 = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b1 = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        String a2 = "1010";
        String b2 = "1011";

        AddBinary_67 addBinary_67 = new AddBinary_67();
        System.out.println(addBinary_67.addBinary(a1, b1));
        System.out.println(addBinary_67.addBinary(a2, b2));
    }
}
