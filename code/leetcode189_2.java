public class leetcode189_2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int s = 0;
        int cur = nums[s];
        for (int i = 0; i < n; i++) {
            int next = (s + k) % n;
            int tmp = nums[next];
            nums[next] = cur;
            cur = tmp;
            s = next;
            if ((i + 1) % (n / gcd(n, k)) == 0) {
                s = (s + 1) % n;
                cur = nums[s];
            }
        }
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
