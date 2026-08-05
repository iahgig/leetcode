import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leetcode207_2 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] degree = new int[numCourses];
        Deque<Integer> que = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(u).add(v);
            degree[v]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                que.offer(i);
                cnt++;
            }
        }
        while (!que.isEmpty()) {
            int i = que.poll();
            for (Integer j : graph.get(i)) {
                if (--degree[j] == 0) {
                    que.offer(j);
                    cnt++;
                }
            }
        }
        if (cnt == numCourses) {
            return true;
        }
        return false;
    }
}
