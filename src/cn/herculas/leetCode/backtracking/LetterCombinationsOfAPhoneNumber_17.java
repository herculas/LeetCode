package cn.herculas.leetCode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_17 {

    private List<String> result = new ArrayList<>();
    private Map<Character, String[]> map = new HashMap<>();
    private String string = "";

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }

        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

        this.find(digits, 0);
        return this.result;
    }

    private void find(String digits, int step) {
        if (step == digits.length()) {
            result.add(this.string);
        } else {
            char t = digits.charAt(step);
            int length = map.get(t).length;

            for (int i = 0; i < length; i++) {
                string += map.get(t)[i];
                this.find(digits, step + 1);
                string = string.substring(0, string.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber_17 letterCombinationsOfAPhoneNumber_17
                = new LetterCombinationsOfAPhoneNumber_17();

        List<String> stringList = letterCombinationsOfAPhoneNumber_17.letterCombinations("23");
        System.out.println(stringList);
    }
}
