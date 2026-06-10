import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode239_1 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
      public int compare(int pair1[], int[] pair2) {
        return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
      }
    });
    for (int i = 0; i < k; i++) {
      q.offer(new int[] { nums[i], i });
    }
    int[] ans = new int[n - k + 1];
    ans[0] = q.peek()[0];
    for (int i = k; i < n; i++) {
      q.offer(new int[] { nums[i], i });
      while (q.peek()[1] <= i - k) {
        q.poll();
      }
      ans[i - k + 1] = q.peek()[0];
    }
    return ans;
  }
}