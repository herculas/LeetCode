package cn.herculas.leetCode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class CourseSchedule_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        HashSet[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<Integer>();
        }

        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.addLast(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer inDegreeNode = queue.removeFirst();
            res.add(inDegreeNode);
            HashSet<Integer> nextCourses = graph[inDegreeNode];
            for (Integer nextCourse : nextCourses) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0)
                    queue.addLast(nextCourse);
            }
        }

        int resLen = res.size();
        if (resLen == numCourses) {
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ret[i] = res.get(i);
            }
            return ret;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        CourseSchedule_210 courseSchedule_210 = new CourseSchedule_210();

        for (int i : courseSchedule_210.findOrder(numCourses, prerequisites)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
