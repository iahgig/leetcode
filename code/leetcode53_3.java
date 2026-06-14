
public class leetcode53_3 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        int min = Math.min(0, sum[0]);
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
            max = Math.max(max, sum[i] - min);
            min = Math.min(min, sum[i]);
        }
        return max;
    }
}
