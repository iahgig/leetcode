public class leetcode101_1 {
    public boolean isSymmetric(TreeNode root) {
        return childisSymmetric(root.left, root.right);
    }

    public boolean childisSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null && left.val == right.val) {
            return childisSymmetric(left.left, right.right) && childisSymmetric(left.right, right.left);
        }
        return false;
    }
}
