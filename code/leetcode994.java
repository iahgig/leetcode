import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode994 {

    public int orangesRotting(int[][] grid) {
        Deque<int[]> que = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!que.isEmpty() && fresh > 0) {
            int cnt = que.size();
            for (int i = 0; i < cnt; i++) {
                int[] p = que.poll();
                for (int j = 0; j < 4; j++) {
                    int x = p[0] + direction[j][0];
                    int y = p[1] + direction[j][1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    fresh--;
                    que.offer(new int[] { x, y });
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}