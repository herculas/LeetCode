package cn.herculas.leetCode.graph;

import java.util.*;

public class CourseSchedule_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 课程表初始化
        List<Set> courses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new HashSet<Integer>());
        }

        // 记录每个课程的后续课程
        for (int[] prerequisite : prerequisites) {
            Set set = courses.get(prerequisite[1]);
            set.add(prerequisite[0]);
        }

        // 记录每门课程的先修课程的数量
        int[] pre = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            Set set = courses.get(i);
            for (Object index : set) {
                pre[(int) index]++;
            }
        }

        // 广度优先搜索 BFS
        for (int i = 0; i < numCourses; i++) {

            // 寻找最先修课程
            int j = 0;
            for (; j < numCourses; j++) {
                if (pre[j] == 0)
                    break;
            }

            // 如果没有最先修课程，则存在环路
            if (j == numCourses)
                return false;

            pre[j] = -1;

            // 将以 j 为最先修课程的所有后续课程的先修数组减 1
            Set tempSet = courses.get(j);
            for (Object index : tempSet) {
                pre[(int) index]--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};

        int[][] prerequisites2 = {{1, 0}};

        CourseSchedule_207 courseSchedule_207 = new CourseSchedule_207();
        System.out.println(courseSchedule_207.canFinish(numCourses, prerequisites));
        System.out.println(courseSchedule_207.canFinish(numCourses, prerequisites2));
    }
}
