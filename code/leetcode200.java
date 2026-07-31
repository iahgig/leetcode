public class leetcode200 {
    boolean vis[][];
    char[][] grid;
    int m;
    int n;

    public int numIslands(char[][] grid) {
        int res = 0;
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    boolean dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || vis[i][j]) {
            return false;
        }
        vis[i][j] = true;
        dfs(i, j + 1);
        dfs(i, j - 1);
        dfs(i + 1, j);
        dfs(i - 1, j);
        return true;
    }
}
