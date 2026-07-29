public class leetcode124 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = root.val;
        int l = solve(root.left);
        int r = solve(root.right);
        int l_gain = Math.max(l, 0);
        int r_gain = Math.max(r, 0);
        res += Math.max(l_gain, r_gain);
        ans = Math.max(ans, root.val + l_gain + r_gain);
        return res;
    }
}