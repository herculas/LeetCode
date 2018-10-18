package cn.herculas.leetCode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] heads = new int[numCourses];
        int[] degrees = new int[numCourses];

        for (int head: heads) {
            head = -1;
        }
        for (int degree: degrees) {
            degree = 0;
        }

        List<Integer> points = new ArrayList<>();
        List<Integer> args = new ArrayList<>();

        int from, to, count = 0;
        int size = prerequisites.length;

        for (int[] prerequisite : prerequisites) {
            to = prerequisite[0];
            from = prerequisite[1];

            degrees[from]++;
            args.add(heads[to]);
            points.add(from);
            heads[to] = count++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }

            while (!queue.isEmpty()) {
                to = queue.getFirst();
                from = heads[to];
                queue.pop();

                while (from != -1) {
                    if (--degrees[points.get(from)] == 0) {
                        queue.push(points.get(from));
                    }
                    from = args.get(from);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] > 0) {
                return false;
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
