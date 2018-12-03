package cn.herculas.leetCode.queue;

import java.util.*;

public class OpenTheLock_752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Collections.addAll(visited, deadends);
        int[] way = {1, -1};

        if (visited.contains("0000"))
            return -1;

        visited.add("0000");
        queue.add("0000");

        int sum = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (Objects.equals(current, target))
                    return sum;
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 2; k++) {
                        assert current != null;
                        char[] cs = current.toCharArray();
                        int digit = (cs[j] - '0' + way[k] + 10) % 10;
                        cs[j] = (char) ('0' + digit);
                        String next = new String(cs);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            sum++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadEnds = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        OpenTheLock_752 openTheLock_752 = new OpenTheLock_752();
        System.out.println(openTheLock_752.openLock(deadEnds, target));
    }
}
