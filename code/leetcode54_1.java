import java.util.ArrayList;
import java.util.List;

public class leetcode54_1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int l = -1;
        int r = matrix[0].length;
        int u = 0;
        int d = matrix.length;
        int i = 0;
        int j = 0;
        int count = r * d;
        while (true) {
            while (j < r) {
                ans.add(matrix[i][j]);
                j++;
            }
            if (ans.size() == count) {
                break;
            }
            j--;
            r--;
            i++;
            while (i < d) {
                ans.add(matrix[i][j]);
                i++;
            }
            if (ans.size() == count) {
                break;
            }
            i--;
            d--;
            j--;
            while (j > l) {
                ans.add(matrix[i][j]);
                j--;
            }
            if (ans.size() == count) {
                break;
            }
            j++;
            l++;
            i--;
            while (i > u) {
                ans.add(matrix[i][j]);
                i--;
            }
            if (ans.size() == count) {
                break;
            }
            i++;
            u++;
            j++;
        }
        return ans;
    }
}
