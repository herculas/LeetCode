package cn.herculas.leetCode.string;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class FirstUniqueCharacter_387 {
    public int firstUniqChar(String s) {

        int size = s.length();

        if (size == 0) {
            return -1;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        char temp;

        for (int i = 0; i < size; i++) {
            temp = s.charAt(i);
            if (hashMap.containsKey(temp)) {
                hashMap.put(temp, size + 1);
            } else {
                hashMap.put(temp, i);
            }
        }

        Collection<Integer> collection = hashMap.values();
        Object[] obj = collection.toArray();
        Arrays.sort(obj);
        int ret = (int) obj[0];

        if (ret >= size) {
            ret = -1;
        }
        return ret;
    }

    public static void main(String[] args) {
        String test = "loveleetcode";

        FirstUniqueCharacter_387 firstUniqueCharacter_387 = new FirstUniqueCharacter_387();
        System.out.println(firstUniqueCharacter_387.firstUniqChar(test));
    }
}
