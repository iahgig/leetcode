import java.util.ArrayList;
import java.util.List;

public class leetcode54_2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (top > bottom || left > right) {
                break;
            }
            for (int j = right; j >= left; j--) {
                ans.add(matrix[bottom][j]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
