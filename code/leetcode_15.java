import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                // j只会增加
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    // 第一次不能跳过
                    continue;
                }
                int k = n - 1;
                // k只会减少
                int target = -nums[i];
                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }
                if (j == k) {
                    // a[j]+a[j+1]>target,显然当前j层循环已无解
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}
