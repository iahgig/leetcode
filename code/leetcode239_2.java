import java.util.Deque;
import java.util.LinkedList;

public class leetcode239_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> dq = new LinkedList<int[]>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= dq.peekLast()[0])
                dq.pollLast();
            dq.offerLast(new int[] { nums[i], i });
        }
        int[] ans = new int[n - k + 1];
        ans[0] = dq.peekFirst()[0];
        for (int i = k; i < n; i++) {
            while (!dq.isEmpty() && nums[i] >= dq.peekLast()[0])
                dq.pollLast();
            dq.offerLast(new int[] { nums[i], i });
            while (dq.peekFirst()[1] <= i - k) {
                dq.pollFirst();
            }
            ans[i - k + 1] = dq.peekFirst()[0];
        }
        return ans;
    }
}
