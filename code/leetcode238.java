public class leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int l = 1;
        int[] R = new int[n];
        R[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            R[i] = l * R[i + 1];
            l *= nums[i];
        }
        R[n - 1] = l;
        return R;
    }
}