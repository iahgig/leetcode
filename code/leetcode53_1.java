import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode53_1 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        pq.offer(new int[] { sum[0], 0 });
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
            pq.offer(new int[] { sum[i], i });
        }
        int max = pq.peek()[0];
        for (int i = 1; i < n; i++) {
            while (pq.peek()[1] < i) {
                pq.poll();
            }
            max = Math.max(max, pq.peek()[0] - sum[i - 1]);
        }
        return max;
    }
}
