package cn.herculas.leetCode.string;

public class ValidPalindrome_125 {
    public boolean isPalindrome (String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }

        s = s.toLowerCase();

        int indexLeft = 0;
        int indexRight = s.length() - 1;

        while (indexLeft <= indexRight) {
            if (!Character.isLetterOrDigit(s.charAt(indexLeft))) {
                indexLeft += 1;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(indexRight))) {
                indexRight -= 1;
                continue;
            }

            if (s.charAt(indexLeft) == s.charAt(indexRight)) {
                indexLeft += 1;
                indexRight -= 1;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        ValidPalindrome_125 validPalindrome_125 = new ValidPalindrome_125();
        System.out.println(validPalindrome_125.isPalindrome(s2));
    }
}
