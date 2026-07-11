public class leetcode543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }
}