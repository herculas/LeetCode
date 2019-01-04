package cn.herculas.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93 {

    private List<String> stringList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return new ArrayList<>();
        this.IPAddresses("", s, 4);
        return this.stringList;
    }

    private void IPAddresses(String prefix, String sub, int cut) {
        if (cut == 0) {
            if (sub.length() == 0) this.stringList.add(prefix.substring(1));
        }

        for (int i = 1; i <= Math.min(3, sub.length()); i++) {
            String thisCut = sub.substring(0, i);

            if (thisCut.length() > 1 && thisCut.charAt(0) == '0') continue;

            int thisCutValue = Integer.valueOf(thisCut);
            if (thisCutValue <= 255) {
                this.IPAddresses(prefix + "." + thisCut, sub.substring(i), cut - 1);
            }
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses_93 restoreIPAddresses_93 = new RestoreIPAddresses_93();
        System.out.println(restoreIPAddresses_93.restoreIpAddresses("010010"));
    }
}
