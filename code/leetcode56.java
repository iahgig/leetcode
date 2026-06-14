import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leetcode56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        int cnt = 0;
        int s = intervals[0][0];
        int e = intervals[0][1];
        List<int[]> ans = new ArrayList<int[]>();
        ans.add(new int[] { s, e });
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= e) {
                e = Math.max(e, intervals[i][1]);
                ans.get(cnt)[1] = e;
            } else {
                cnt++;
                ans.add(intervals[i]);
                e = intervals[i][1];
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
