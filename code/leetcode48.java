public class leetcode48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int left = 0;
        int right = n - 2;
        while (left <= right) {
            for (int j = left; j <= right; j++) {
                int[] cur = new int[3];
                cur[0] = left;
                cur[1] = j;
                cur[2] = matrix[left][j];
                for (int i = 0; i < 4; i++) {
                    int[] tmp = new int[3];
                    tmp[0] = cur[1];
                    tmp[1] = n - 1 - cur[0];
                    tmp[2] = matrix[tmp[0]][tmp[1]];
                    matrix[tmp[0]][tmp[1]] = cur[2];
                    cur[0] = tmp[0];
                    cur[1] = tmp[1];
                    cur[2] = tmp[2];
                }
            }
            left++;
            right--;
        }
    }
}