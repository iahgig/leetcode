public class leetcode240_1{
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return search(matrix, target, 0, 0, m - 1, n - 1);
    }

    public boolean search(int[][] matrix, int target, int top, int left, int bottom, int right) {
        if (left > right || top > bottom) {
            return false;
        }
        if (target < matrix[top][left] || target > matrix[bottom][right]) {
            return false;
        }
        int r_mid = (top + bottom) / 2;
        int c_mid = (left + right) / 2;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        if (matrix[r_mid][c_mid] == target)
            return true;
        else if (matrix[r_mid][c_mid] < target) {
            flag1 = search(matrix, target, r_mid + 1, c_mid + 1, bottom, right);
            flag2 = search(matrix, target, r_mid + 1, left, bottom, c_mid);
            flag3 = search(matrix, target, top, c_mid + 1, r_mid, right);
        } else {
            flag1 = search(matrix, target, top, left, r_mid - 1, c_mid - 1);
            flag2 = search(matrix, target, r_mid, left, bottom, c_mid - 1);
            flag3 = search(matrix, target, top, c_mid, r_mid - 1, right);
        }
        if (flag1 || flag2 || flag3)
            return true;
        return false;
    }
}