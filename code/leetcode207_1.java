import java.util.ArrayList;
import java.util.List;

public class leetcode207_1 {

    List<List<Integer>> edge;
    boolean[] visiting;
    boolean[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visiting = new boolean[numCourses];
        visited = new boolean[numCourses];
        int length = prerequisites.length;
        edge = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }
        for (int i = 0; i < length; i++) {
            edge.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int i) {
        if (visiting[i]) {
            return false;
        }
        if (visited[i]) {
            return true;
        }
        visiting[i] = true;
        for (Integer it : edge.get(i)) {
            if (!dfs(it)) {
                return false;
            }
        }
        visiting[i] = false;
        visited[i] = true;
        return true;
    }
}