package cn.herculas.leetCode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeysAndRooms_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] visited = new boolean[size];

        visited[0] = true;
        this.dfs(0, rooms, visited);

        for (boolean visit : visited) {
            if (!visit)
                return false;
        }
        return true;
    }

    private void dfs(int thisRoom, List<List<Integer>> rooms, boolean[] visited) {
        for (int nextRoom : rooms.get(thisRoom)) {
            if (!visited[nextRoom]) {
                visited[nextRoom] = true;
                this.dfs(nextRoom, rooms, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        list0.add(3);

        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(0);
        list1.add(1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);

        List<Integer> list3 = new ArrayList<>();
        list2.add(0);

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(list0);
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);

        KeysAndRooms_841 keysAndRooms_841 = new KeysAndRooms_841();
        System.out.println(keysAndRooms_841.canVisitAllRooms(rooms));
    }
}
