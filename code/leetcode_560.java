import java.util.HashMap;
import java.util.Map;

public class leetcode_560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        // 对于给定i，mp.get(key）等于所有j大于等于i且sum[j]=key的j的个数
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            mp.put(sum[i], mp.getOrDefault(sum[i], 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans += mp.getOrDefault(k, 0);
            } else {
                ans += mp.getOrDefault(k + sum[i - 1], 0);
            }
            mp.put(sum[i], mp.get(sum[i]) - 1);
        }
        return ans;
    }
}
