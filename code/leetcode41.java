public class leetcode41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] <= n && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        int ans = n + 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
}